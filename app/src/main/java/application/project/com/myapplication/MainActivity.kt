package application.project.com.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import android.R.attr.data
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.btn)
        et1.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                tv12.text = "${s.toString()}  ${et2.text}"
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        et2.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                tv12.text = "${et1.text}  ${s.toString()}"
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        et3.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                tv22.text = s.toString()
            }
        })

        et4.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                tv32.text = s.toString()
            }
        })

        val response = intent.getStringExtra("response")
        answerTv.text = response
        btn.setOnClickListener{
            val intent = Intent(this,Answer::class.java).apply{
                putExtra("name","${et1.text} ${et2.text}")
                putExtra("phone",et3.text.toString())
                putExtra("message",et4.text.toString())
            }
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Toast.makeText(this,"null!",Toast.LENGTH_SHORT).show()
        if(data == null)
            Toast.makeText(this,"null!",Toast.LENGTH_SHORT).show()
        answerTv.text = data?.getStringExtra("response").toString()
    }
}
