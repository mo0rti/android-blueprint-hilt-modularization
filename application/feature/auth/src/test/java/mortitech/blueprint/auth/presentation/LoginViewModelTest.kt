package mortitech.blueprint.auth.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import mortitech.blueprint.auth.navigation.AuthCoordinatorEvent
import mortitech.blueprint.auth.presentation.login.LoginViewContract
import mortitech.blueprint.auth.presentation.login.LoginViewModel
import mortitech.blueprint.auth.presentation.utils.MainDispatcherRule
import mortitech.blueprint.auth.usecase.AuthUserCases
import mortitech.blueprint.auth.usecase.LoginUseCase
import mortitech.blueprint.auth.usecase.ResetPasswordUseCase
import mortitech.blueprint.auth.usecase.SignupUseCase
import mortitech.blueprint.core.exception.InvalidInputException
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

@ExperimentalCoroutinesApi
class LoginViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @MockK(relaxed = true)
    private lateinit var loginUseCase: LoginUseCase

    @MockK(relaxed = true)
    private lateinit var signupUseCase: SignupUseCase

    @MockK(relaxed = true)
    private lateinit var resetPasswordUseCase: ResetPasswordUseCase

    // System Under Test
    private lateinit var loginViewModel: LoginViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        loginViewModel = LoginViewModel(
            AuthUserCases(loginUseCase, signupUseCase, resetPasswordUseCase),
            mainDispatcherRule.testDispatcher
        )
    }

    @Test
    fun `login with valid credentials updates state and sends account flow event`() = runTest {
            // Given
            val username = "user123"
            val password = "password123"
            val expectedState = LoginViewContract.State(isLoading = false, username = username, password = password)

            coEvery { loginUseCase.invoke(username, password) } just Runs

            // When
            loginViewModel.updateViewAction(LoginViewContract.Action.OnUserNameTextChanged(username))
            loginViewModel.updateViewAction(LoginViewContract.Action.OnPasswordTextChanged(password))
            loginViewModel.updateViewAction(LoginViewContract.Action.OnLoginButtonClicked)

            // Then
            coVerify { loginUseCase.invoke(username, password) }
            assertEquals(expectedState, loginViewModel.currentViewState())
            loginViewModel.coordinatorEvent.test {
                assertEquals(AuthCoordinatorEvent.AccountFlow, this.awaitItem())
                awaitComplete()
            }
        }

    @Test
    fun `login with invalid credentials shows error toast`() = runTest {
        // Given
        val username = "user123"
        val password = "short"
        val errorMessage = "Password should be at least 6 characters"
        val expectedState = LoginViewContract.State(isLoading = false, username = username, password = password)
        coEvery { loginUseCase.invoke(username, password) } throws InvalidInputException(errorMessage)

        // When
        loginViewModel.updateViewAction(LoginViewContract.Action.OnLoginButtonClicked)

        // Then
        coVerify { loginUseCase.invoke(username, password) }
        assertEquals(expectedState, loginViewModel.currentViewState())
        loginViewModel.viewEvent.test {
            assertEquals(LoginViewContract.Event.ShowErrorToast(errorMessage), awaitItem())
        }
    }
}
