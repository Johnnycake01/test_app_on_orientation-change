package com.example.tutorapplication

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
//class of main activity that extend app compact activity
class MainActivity : AppCompatActivity(){
    //initializing variable to count number of orientation change

    private var landscapeCount = 0
    private val handler = Handler(Looper.getMainLooper())//handler to delay display of some content
    //this function runs immediately the app is created
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //locate activity to display
        //handler call to action
        handler.postDelayed({
            "on create mode".also { firstTextView.text = it }
        },500)
        Toast.makeText(this, "lunching app", Toast.LENGTH_SHORT).show() //short pop up message to user
        //check current configuration position of the app
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){

            "This is Portrait mode, Portrait mode has been launched $landscapeCount time(s)".also { secondTextView.text = it }
        } else {

            "This is Landscape mode, Landscape mode has been launched $landscapeCount time(s)".also { secondTextView.text = it }
        }
    }

    /*save instance state of the application before restart or refresh
     helps to handle configuration change in time of screen rotation*/
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("savedLandscape", landscapeCount)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val intSaved = savedInstanceState.getInt("savedLandscape",0)
        landscapeCount = intSaved
         }

//after the on create stage comes the on start state
    override fun onStart() {
        super.onStart()
        handler.postDelayed({
            "this application is starting".also { firstTextView.text = it }
        },1000)
        Toast.makeText(this, "this application is starting", Toast.LENGTH_SHORT).show()
    }

    //this state loads when the application is fully loaded, this stage is very visible to user
    override fun onResume() {
        super.onResume()
        handler.postDelayed({
            "on resume mode".also { firstTextView.text = it }
        },1500)

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
            landscapeCount++
            "(Portrait mode) count is: $landscapeCount".also { secondTextView.text = it }
        } else {
            // increase counter after configuration changes to landscape
                landscapeCount++
            "(Landscape mode) count is: $landscapeCount time(s)".also { secondTextView.text = it }
        }
    }

    //this shows when the application is minimised or partially visible to the user
    override fun onPause(){
        super.onPause()
        "this Application has been paused".also { firstTextView.text = it }
        Toast.makeText(this, "the Application has been paused", Toast.LENGTH_SHORT).show()
    }

    //this state runs immediately when the program is stopped
    override fun onStop() {
        super.onStop()
        "this application has stopped".also { firstTextView.text = it }
        Toast.makeText(this, "this application has stopped", Toast.LENGTH_SHORT).show()
    }

/// this code runs on restart of application
    override fun onRestart() {
        super.onRestart()
    "this application has restarting".also { firstTextView.text = it }
        Toast.makeText(this, "this application is restarting", Toast.LENGTH_SHORT).show()
    }

    // this runs after application has been terminated
    override fun onDestroy() {
        super.onDestroy()
        "this application has been destroyed".also { firstTextView.text = it }
        Toast.makeText(this, "this application has been destroyed", Toast.LENGTH_SHORT).show()
    }


}