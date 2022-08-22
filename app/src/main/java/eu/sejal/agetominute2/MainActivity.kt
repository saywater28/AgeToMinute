   package eu.sejal.agetominute2

   import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
//   import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.text.SimpleDateFormat

   class MainActivity : AppCompatActivity() {


       override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDatePicker.setOnClickListener { view ->
            clickDatePicker(view)

        }
    }

    fun clickDatePicker(view: View) {

        val myCalender = Calender.getInstance()
        val year = myCalender.get(Calender.YEAR)
        val month = myCalender.get(Calender.MONTH)
        val day = myCalender.get(Calender.DAY_OF_MONTH)

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener {
                    view, selectedYear, selectedMonth, selectedDayOfMonth ->
                Toast.makeText(this,
                    "The chosen year is  $year, the month is $month and the day is $day",
                    Toast.LENGTH_LONG).show()

                val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"


                tvSelectedDate.setText(selectedDate)

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val theDate = sdf.parse(selectedDate)

                val selectedDateInMinutes = theDate.time


            }
            ,year
            ,month
            ,day).show()
    }

}