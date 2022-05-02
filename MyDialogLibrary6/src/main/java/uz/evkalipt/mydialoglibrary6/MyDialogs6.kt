package uz.evkalipt.mydialoglibrary6

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.color.colorChooser
import com.google.android.material.bottomsheet.BottomSheetDialog

object MyDialogs6 {

    fun alertDialog(context: Context, title:String, message:String, posButton:String, negButton:String){
        val alert = AlertDialog.Builder(context)
        alert.setTitle(title)
        alert.setMessage(message)
        alert.setPositiveButton(posButton
        ) { p0, _ -> p0?.dismiss() }
        alert.setNegativeButton(negButton
        ) { p0, _ -> p0?.dismiss() }
        alert.show()
    }

    fun chekDialog(
        context: Context,
        title: String,
        itemList: Array<String>,
        posButton:String
    ){
        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setTitle(title)
        alertDialog.setPositiveButton(posButton
        ) { p0, _ -> p0?.dismiss() }
        alertDialog.setMultiChoiceItems(itemList, null){ _, w, _ ->
            Toast.makeText(context, itemList[w], Toast.LENGTH_SHORT).show()
        }
        alertDialog.show()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun calendarDialog(context: Context){
        val pickerDialog = DatePickerDialog(context)
        pickerDialog.show()
    }

    fun chekWifi(context: Context){
        val bottomSheetDialog = BottomSheetDialog(context)
        bottomSheetDialog.setContentView(R.layout.item)
        bottomSheetDialog.show()
    }

    fun colors(context: Context, title: String, colors:IntArray){
        MaterialDialog(context).show {
            title(0, title)
            colorChooser(colors) { _, color ->
                Toast.makeText(context, color.toString(), Toast.LENGTH_SHORT).show()
            }
            negativeButton(null, "Cancel") {
                it.dismiss()
            }
            positiveButton(null, "Select")
        }
    }

}