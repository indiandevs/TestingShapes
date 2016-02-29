package testing.testingshapes;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by baymax on 27/2/16.
 */


    public class ErrorDialogMessage {


        Context context;


        ErrorDialogMessage(Context c){

            this.context = c;
        }


        void show(){


            AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
            builder1.setMessage("CHECK INTERNET CONNECTION");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {


                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();





        }




        void show(String message){


            AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
            builder1.setMessage(message);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {


                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();





        }



    }

