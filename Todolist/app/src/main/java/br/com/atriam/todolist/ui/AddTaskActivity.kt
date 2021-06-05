package br.com.atriam.todolist.ui
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.atriam.todolist.databinding.ActivityAddTaskBinding
import br.com.atriam.todolist.extensions.format
import br.com.atriam.todolist.extensions.text
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.*


class AddTaskActivity : AppCompatActivity () {
    private lateinit var binding: ActivityAddTaskBinding

    override fun onCreate(savedInstanceState: Bundle? )
    {
        super.onCreate( savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {
        binding.tilDate.editText?.setOnClickListener {
            //Log.e("TAG", "insertListeners: ")
            val datePicker = MaterialDatePicker.Builder.datePicker().build()
            datePicker.addOnPositiveButtonClickListener {
                val timeZone = TimeZone.getDefault()
                val offset = timeZone.getOffset(Date().time) * -1
                binding.tilDate.text = Date(it + offset).format()
            }
            datePicker.show(supportFragmentManager, "DATE_PICKER_TAG")

        }
    }
}