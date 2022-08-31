package german.adrian.quiz

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.android.material.snackbar.Snackbar
import german.adrian.quiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //private lateinit var trueButton : Button
    //private lateinit var falseButton : Button

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

    private var currentIndex = 0

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //trueButton = findViewById(R. id.true_button)
        //falseButton = findViewById(R. id.false_button)

        binding.trueButton.setOnClickListener { view: View ->
            //Toast.makeText(this, R.string.correct_toast,Toast.LENGTH_SHORT).show()
            //val SnackBar = Snackbar.make(view, R.string.correct_toast, Snackbar.LENGTH_LONG)
            //SnackBar.setBackgroundTint(getColor(R.color.green))
            //SnackBar.show()
            checkAnswer(true)



        }
        binding.falseButton.setOnClickListener { view: View ->
            //Toast.makeText(this, R.string.incorrect_toast,Toast.LENGTH_SHORT).show()
            //val SnackBar = Snackbar.make(view, R.string.incorrect_toast, Snackbar.LENGTH_LONG)
            //SnackBar.setBackgroundTint(getColor(R.color.red))
            //SnackBar.show()
            checkAnswer(false)

        }

        binding.nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            //val questionTextResId = questionBank[currentIndex] . textResId
            //binding.questionTextView.setText(questionTextResId)
            updateQuestion()
        }


        //val questionTextResId = questionBank[currentIndex].textResId
        //binding.questionTextView.setText(questionTextResId)
        updateQuestion()
        }


    private fun checkAnswer (userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].respuesta

        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT) .show()

    }



    private fun updateQuestion(){
        val questionTextResId = questionBank[currentIndex]. textResId
        binding.questionTextView.setText(questionTextResId)
    }



}