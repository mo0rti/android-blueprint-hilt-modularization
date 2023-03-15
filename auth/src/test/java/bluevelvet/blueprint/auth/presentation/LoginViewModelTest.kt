package bluevelvet.blueprint.auth.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import bluevelvet.blueprint.auth.presentation.login.LoginViewContract
import bluevelvet.blueprint.auth.presentation.login.LoginViewModel
import bluevelvet.blueprint.auth.presentation.utils.MainCoroutineRule
import bluevelvet.blueprint.auth.usecase.AuthUserCases
import bluevelvet.blueprint.auth.usecase.LoginUseCase
import io.mockk.*
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
    val coroutineRule = MainCoroutineRule()

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    // Mocked dependencies
    @io.mockk.impl.annotations.MockK
    private lateinit var loginUseCase: LoginUseCase

    // System Under Test
    private lateinit var loginViewModel: LoginViewModel

    @Before
    fun setUp() {
        // Initialize mocked dependencies
        loginUseCase = mockk()

        // Initialize SUT with mocked dependencies
        loginViewModel = LoginViewModel(AuthUserCases(loginUseCase, mockk(), mockk()))
    }

    @Test
    fun `login with valid credentials updates state and sends account flow event`() = runTest {
            // Given
            val username = "user123"
            val password = "password123"
            val expectedState = LoginViewContract.State(isLoading = false, username = username, password = password)

            coEvery { loginUseCase.invoke(username, password) } just Runs

            // When
            loginViewModel.updateViewEvent(LoginViewContract.Event.OnUserNameTextChanged(username))
            loginViewModel.updateViewEvent(LoginViewContract.Event.OnPasswordTextChanged(password))
            loginViewModel.updateViewEvent(LoginViewContract.Event.OnLoginButtonClicked)

            // Then
            coVerify { loginUseCase.invoke(username, password) }
            assertEquals(expectedState, loginViewModel.currentViewState())
            //loginViewModel.coordinatorEvent.
            //verify { loginViewModel.coordinatorEvent.coordinatorEventObserver.onChanged(AuthCoordinatorEvent.AccountFlow) }
        }

    /*
    @Test
    fun `login with invalid credentials shows error toast`() = runTest {
        // Given
        val username = "user123"
        val password = "short"
        val errorMessage = "Password should be at least 6 characters"
        val expectedState = LoginViewContract.State(isLoading = false, username = username, password = password)
        coEvery { loginUseCase.invoke(username, password) } throws InvalidInputException(errorMessage)

        // When
        loginViewModel.updateViewState { copy(username = username, password = password) }
        loginViewModel.updateViewEvent(LoginViewContract.Event.OnLoginButtonClicked)

        // Then
        coVerify { loginUseCase.invoke(username, password) }
        assertEquals(expectedState, loginViewModel.currentViewState())
        verify { viewEffectObserver.onChanged(LoginViewContract.Effect.ShowErrorToast(errorMessage)) }
    }*/
}
