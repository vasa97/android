package application.project.com.myapplication

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_answer.*

class Answer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)
        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val message = intent.getStringExtra("message")
        te1.text = name
        te2.text = phone
        te3.text = message
        button.setOnClickListener{
            val intent = Intent(this,Answer::class.java).apply{
                putExtra("response",ed.text.toString())
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
