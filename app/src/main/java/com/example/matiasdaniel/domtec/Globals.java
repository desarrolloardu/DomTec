package com.example.matiasdaniel.domtec;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

/**
 * Created by MatiasDaniel on 11/4/2016.
 */
public class Globals extends Application {

    public BluetoothAdapter BA = null;
    public BluetoothSocket btSocket = null;
    public OutputStream outStream = null;
    //////////////////////////////////////
    public static final UUID MY_UUID =
            UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    public String address = "";  //la mac del arduino Bluetooth
//////////////////////////////////////

    public void sendData(String message) {

        byte[] msgBuffer = message.getBytes();

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        try {
            outStream.write(msgBuffer);
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "IOException Fatal Error1: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        catch(Exception e2)
        {
            Toast.makeText(getApplicationContext(), "Fatal Error2: " + e2.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public int ConectarBluetooth(String BTadress){

        this.address = BTadress;
        int falla = 0;
       // Globals g = (Globals)getApplication();
        //Toast.makeText(getApplicationContext(), "Conectando", Toast.LENGTH_SHORT).show();

        // Set up a pointer to the remote node using it's address.
        BluetoothDevice device = BA.getRemoteDevice(address);

        Toast.makeText(getApplicationContext(), "Conectando a:" + device.getAddress(), Toast.LENGTH_SHORT).show();

        // Two things are needed to make a connection:
        //   A MAC address, which we got above.
        //   A Service ID or UUID.  In this case we are using the
        //     UUID for SPP.
        try {
            btSocket = device.createRfcommSocketToServiceRecord(MY_UUID);
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Fatal Error - socket create failed: " + e.getMessage() + ".", Toast.LENGTH_SHORT).show();
            falla = -1;
        }catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Fatal Error - socket create failed: " + ex.getMessage() + ".", Toast.LENGTH_SHORT).show();
            falla = -1;
        }

        // Discovery is resource intensive.  Make sure it isn't going on
        // when you attempt to connect and pass your message.
        BA.cancelDiscovery();

        try {
            btSocket.connect();
            Toast.makeText(getApplicationContext(), "Conecto OK a:" + device.getAddress(), Toast.LENGTH_SHORT).show();

            try {
                outStream = btSocket.getOutputStream();
            } catch (IOException e) {
                Toast.makeText(getApplicationContext(), "Output stream creation failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                falla = -2;
            }catch (Exception ex) {
                Toast.makeText(getApplicationContext(), "Fatal Error - socket create failed: " + ex.getMessage() + ".", Toast.LENGTH_SHORT).show();
                falla = -2;
            }

        } catch (IOException e) {
            try {
                btSocket.close();
            } catch (IOException e2) {
                Toast.makeText(getApplicationContext(), "Fatal Error - unable to close socket during connection failure: " + e2.getMessage() + ".", Toast.LENGTH_SHORT).show();
                falla = -3;
            }catch (Exception ex) {
                Toast.makeText(getApplicationContext(), "Fatal Error - socket create failed: " + ex.getMessage() + ".", Toast.LENGTH_SHORT).show();
                falla = -3;
            }

            Toast.makeText(getApplicationContext(), "Fatal Error - socket connection failed: " + e.getMessage() + ".", Toast.LENGTH_SHORT).show();
            falla = -4;
        }

        return falla;
    }

    public void DesconectarBluetooth() {
      /*  if (mBTInputStream != null) {
            try {mBTInputStream.close();} catch (Exception e) {}
            mBTInputStream = null;
        }
*/
        if (outStream != null) {
            try {outStream.close();} catch (Exception e) {}
            outStream = null;
        }

        if (btSocket != null) {
            try {btSocket.close();} catch (Exception e) {}
            btSocket = null;
        }
        Toast.makeText(getApplicationContext(), "Bluetooth desconectado.", Toast.LENGTH_SHORT).show();
    }
}