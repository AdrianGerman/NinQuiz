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
        Question(R.string.question_kong, true)
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
            val SnackBar = Snackbar.make(view, R.string.correct_toast, Snackbar.LENGTH_LONG)
            SnackBar.setBackgroundTint(getColor(R.color.green))
            SnackBar.show()



        }
        binding.falseButton.setOnClickListener { view: View ->
            //Toast.makeText(this, R.string.incorrect_toast,Toast.LENGTH_SHORT).show()
            val SnackBar = Snackbar.make(view, R.string.incorrect_toast, Snackbar.LENGTH_LONG)
            SnackBar.setBackgroundTint(getColor(R.color.red))
            SnackBar.show()
        }


        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionTextView.setText(questionTextResId)
    }
}