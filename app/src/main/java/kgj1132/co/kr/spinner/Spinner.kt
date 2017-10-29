package kgj1132.co.kr.spinner

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_spinner.*
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable



class Spinner : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        val plusbutton = RxView.clicks(plus)
                .map({event->Integer.parseInt(textView.text.toString())+1})

        val minusbutton = RxView.clicks(minus)
                .map({event->Integer.parseInt(textView.text.toString())-1})

        val together = Observable.merge(plusbutton, minusbutton)

        together.subscribe { value -> textView.text = value.toString() }
    }
}
