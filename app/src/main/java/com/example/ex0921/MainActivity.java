package com.example.ex0921;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    AlertDialog.Builder adb;
    Random rnd;
    int rndColor;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rnd = new Random();
    }

    /**
     *             The function Displays an alert dialog with a message
     *
     * @param view The view that triggered the click event
     */
    public void clickedBtn1(View view)
    {
        adb = new AlertDialog.Builder(this);

        adb.setMessage("you've clicked button1");

        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     *              The function Displays an alert dialog with a message and an icon.
     *
     * @param view The view that triggered the click event
     */
    public void clickedBtn2(View view)
    {
        adb = new AlertDialog.Builder(this);

        adb.setMessage("you've clicked button2");
        adb.setIcon(R.drawable.icon1);

        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     *              The function Displays an alert dialog with a message, an icon, and a neutral
     *              button to close the dialog.
     *
     * @param view The view that triggered the click event
     */
    public void clickedBtn3(View view)
    {
        adb = new AlertDialog.Builder(this);

        adb.setMessage("you've clicked button3");
        adb.setIcon(R.drawable.icon2);
        adb.setCancelable(false);

        adb.setNeutralButton("close", new DialogInterface.OnClickListener()
        {
            /**
             *                 The function Cancels the dialog when the natural button is clicked.
             *
             * @param dialog The dialog that triggered the click event
             * @param i      The button that was clicked
             */
            @Override
            public void onClick(DialogInterface dialog, int i)
            {
                dialog.cancel();
            }
        });

        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     *                  The function Displays an alert dialog with a message, a positive
     *                  button to change the background color and a neutral button to close the dialog.
     *
     * @param view The view that triggered the click event
     */
    public void clickedBtn4(View view)
    {
        adb = new AlertDialog.Builder(this);

        adb.setMessage("to change background color click 'change'");
        adb.setCancelable(false);

        adb.setPositiveButton("change", new DialogInterface.OnClickListener()
        {
            /**
             *                The function changes the background color randomly when the positive
             *                button is clicked
             *
             * @param dialog The dialog that triggered the click event
             * @param i      The button that was clicked
             */
            @Override
            public void onClick(DialogInterface dialog, int i)
            {
                rndColor = Color.rgb ( rnd.nextInt(256),
                                       rnd.nextInt(256),
                                       rnd.nextInt(256) );
                getWindow().getDecorView().setBackgroundColor(rndColor);
            }
        });

        adb.setNeutralButton("close", new DialogInterface.OnClickListener()
        {
            /**
             *                 The function Cancels the dialog when the natural button is clicked.
             *
             * @param dialog The dialog that triggered the click event
             * @param i      The button that was clicked
             */
            @Override
            public void onClick(DialogInterface dialog, int i)
            {
                dialog.cancel();
            }
        });

        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     *                  The function Displays an alert dialog with a message, a positive
     *                  button to change the background color, a negative button to change the background
     *                  color back to white and a neutral button to close the dialog.
     *
     * @param view The view that triggered the click event
     */
    public void clickedBtn5(View view)
    {
        adb = new AlertDialog.Builder(this);

        adb.setMessage("to change background color click 'change'");
        adb.setCancelable(false);

        adb.setPositiveButton("change", new DialogInterface.OnClickListener()
        {
            /**
             *                The function changes the background color randomly when the positive
             *                button is clicked
             *
             * @param dialog The dialog that triggered the click event
             * @param i      The button that was clicked
             */
            @Override
            public void onClick(DialogInterface dialog, int i)
            {
                rndColor = Color.rgb ( rnd.nextInt(256),
                        rnd.nextInt(256),
                        rnd.nextInt(256) );
                getWindow().getDecorView().setBackgroundColor(rndColor);
            }
        });

        adb.setNegativeButton("restore", new DialogInterface.OnClickListener()
        {
            /**
             *                 The function changes the background back to white when the negative
             *                 button is clicked.
             *
             * @param dialog The dialog that triggered the click event
             * @param i      The button that was clicked
             */
            @Override
            public void onClick(DialogInterface dialog, int i)
            {
                getWindow().getDecorView().setBackgroundColor(Color.WHITE);
            }
        });

        adb.setNeutralButton("close", new DialogInterface.OnClickListener()
        {
            /**
             *                 The function Cancels the dialog when the natural button is clicked.
             *
             * @param dialog The dialog that triggered the click event
             * @param i      The button that was clicked
             */
            @Override
            public void onClick(DialogInterface dialog, int i)
            {
                dialog.cancel();
            }
        });

        AlertDialog ad = adb.create();
        ad.show();
    }

    public void clickedCredits(View view)
    {
        intent = new Intent(this, Credits.class);
        startActivity(intent);
    }
}



