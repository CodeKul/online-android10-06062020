package com.ani.online.notifications

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

import splitties.alertdialog.appcompat.alertDialog
import splitties.alertdialog.appcompat.cancelButton
import splitties.alertdialog.appcompat.messageResource
import splitties.alertdialog.appcompat.okButton
import splitties.alertdialog.appcompat.onShow
import splitties.alertdialog.appcompat.positiveButton

class AppDialogFragment : DialogFragment() {

    companion object {
        const val DIALOG_LOGIN = "login"
        const val DIALOG_DELETE_CONFIRM = "delete_confirm"
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        when(tag) {
            DIALOG_LOGIN -> return loginDialog()
            DIALOG_DELETE_CONFIRM -> return deleteConfirm()
        }
        return Dialog(context as MainActivity)
    }

    private fun loginDialog() : Dialog {
        val inflater = LayoutInflater.from(activity as Context)
        val dv = inflater.inflate(R.layout.fragment_app_dialog, null, false)

        val builder = AlertDialog.Builder(activity as Context)
        val dialog = builder.create()
        dialog.setView(dv)
        return dialog
    }

    private fun deleteConfirm() : Dialog {
        return AlertDialog.Builder(activity as Context)
            .setIcon(R.drawable.ic_baseline_notifications_24)
            .setTitle("Confirm")
            .setMessage("Are you sure, you want to Delete ??")
            .setPositiveButton("Yes", { di, wh ->  })
            .setNegativeButton("No", { di, wh -> })
            .create()
    }

    private fun lessDialogCode() {

    }
}