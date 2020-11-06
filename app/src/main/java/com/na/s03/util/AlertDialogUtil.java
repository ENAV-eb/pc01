package com.na.s03.util;

import android.content.Context;
import  android.app.AlertDialog;
import android.widget.Toast;


import com.na.s03.R;

public class AlertDialogUtil {

    /**
     * Shows alert dialog with provided message.
     *
     * @param error Error message to be displayed.
     * @param context Application context.
     */
    public static void showAlertDialog(String error, Context context) {
        try {
           AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(Constantes.TITULO_ALERT_ERROR);

            builder.setMessage("Debe ingresar el campo "+error);
            builder.setNegativeButton("CONTINUAR", null);

            AlertDialog dialog = builder.create();
            dialog.show();

        } catch (final Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}
