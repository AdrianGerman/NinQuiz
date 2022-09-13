package german.adrian.quiz

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"

class QuizViewModel (private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val questionBank = listOf(
        Question(R.string.question_zelda, true),
        Question(R.string.question_mario, false),
        Question(R.string.question_kong, true),
        Question(R.string.question_year, false),
        Question(R.string.question_gameboy, true),
        Question(R.string.question_mano, true),
        Question(R.string.question_jumpman, true),
        Question(R.string.question_yoshi, true),
        Question(R.string.question_nin, false),
        Question(R.string.question_consola, false),
    )

    private var currentIndex: Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].respuesta

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    fun moveToPrev() {
        currentIndex = (currentIndex - 1) % questionBank.size
    }

}