package uz.evkalipt.mydialoglibrary6

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast

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

}