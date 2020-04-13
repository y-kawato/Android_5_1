package jp.co.stv_tech.android_5_1

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class OrderConfirmDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)

        builder.setTitle(R.string.dialog_title)
        builder.setMessage(R.string.dialog_msg)

        builder.setPositiveButton(R.string.dialog_btn_ok, DialogButtonClickLIstener())
        builder.setNegativeButton(R.string.dialog_btn_ng, DialogButtonClickLIstener())
        builder.setNeutralButton(R.string.dialog_btn_nu, DialogButtonClickLIstener())

        val dialog = builder.create()
        return dialog
    }

    private inner class DialogButtonClickLIstener : DialogInterface.OnClickListener {
        override fun onClick(dialog: DialogInterface, which: Int) {
            var msg = ""

            when(which) {
                DialogInterface.BUTTON_POSITIVE ->

                    msg = getString(R.string.dialog_ok_toast)

                DialogInterface.BUTTON_NEGATIVE ->

                    msg = getString(R.string.dialog_ng_toast)

                DialogInterface.BUTTON_NEUTRAL ->

                    msg =
                        getString(R.string.dialog_nu_toast)
            }

            Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
        }
    }
}