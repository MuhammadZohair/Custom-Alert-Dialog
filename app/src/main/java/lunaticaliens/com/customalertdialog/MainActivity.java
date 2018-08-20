package lunaticaliens.com.customalertdialog;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

/**
 * Project Title: Custom Alert Dialog
 * Created on: 31/07/2018
 * Created By: Muhammad Zohair (zohair739@gmail.com)
 * Description: This is an example project for custom alert dialog that contains custom widgets
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /* Button that opens the alert dialog when clicked */
    private Button popupButton;

    /**
     * This method in the activity life cycle is called when the activity is created
     *
     * @param savedInstanceState to transfer data between activities
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        popupButton = findViewById(R.id.buttonMain); //initialize the button
        popupButton.setOnClickListener(this); // set click listener

    }

    /**
     * this method overrides the onClick property and is called whenever a button is clicked
     *
     * @param view the view of the activity
     */
    @Override
    public void onClick(View view) {
        if (view == popupButton) {

            /* Create the alert dialog object in the current activity. */
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            //inflate our own xml file to attach it with the alert dialog
            LayoutInflater inflater = getLayoutInflater();
            @SuppressLint("InflateParams") View dialogView = inflater.inflate(R.layout.custom_layout, null);

            builder.setView(dialogView); // set the view with our xml

            /* Attributes of our custom dialog box (Can be changed according to desired output) */
            Button oneButton = dialogView.findViewById(R.id.button1);
            Button twoButton = dialogView.findViewById(R.id.button2);
            Button threeButton = dialogView.findViewById(R.id.button3);
            Button fourButton = dialogView.findViewById(R.id.button4);
            Button cancelButton = dialogView.findViewById(R.id.cancelButton);

            /* create the dialog using builder*/
            final AlertDialog dialog = builder.create();
            Objects.requireNonNull(dialog.getWindow())
                    .setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // set the background of the dialog to transparent

            dialog.setCancelable(false); // dialog cannot be cancelled by clicking outside of the dialog

            /* set click listener for the first button */
            oneButton.setOnClickListener(new View.OnClickListener() {

                /**
                 *
                 * @param v the view of the activity
                 */
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Button 1 Selected", Toast.LENGTH_SHORT).show(); // toast the user
                    dialog.dismiss(); // dismiss the dialog manually

                }
            });

            /* set click listener for the second button */
            twoButton.setOnClickListener(new View.OnClickListener() {

                /**
                 *
                 * @param v the view of the activity
                 */
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Button 2 Selected", Toast.LENGTH_SHORT).show(); // toast the user
                    dialog.dismiss();// dismiss the dialog manually
                }
            });

            /* set click listener for the third button */
            threeButton.setOnClickListener(new View.OnClickListener() {

                /**
                 *
                 * @param v the view of the activity
                 */
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Button 3 Selected", Toast.LENGTH_SHORT).show(); // toast the user
                    dialog.dismiss();// dismiss the dialog manually

                }
            });

            /* set click listener for the fourth button */
            fourButton.setOnClickListener(new View.OnClickListener() {

                /**
                 *
                 * @param v the view of the activity
                 */
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Button 4 Selected", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();// dismiss the dialog manually

                }
            });

            /* set click listener for the cancel button */
            cancelButton.setOnClickListener(new View.OnClickListener() {

                /**
                 *
                 * @param v view given to the method
                 */
                @Override
                public void onClick(View v) {

                    dialog.dismiss();// dismiss the dialog manually

                }
            });

            // Display the custom alert dialog on interface
            dialog.show();
        }


    }
}
