package com.dialog.hello;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.widget.EditText;



public class ActivityIndicator extends CordovaPlugin {

	private ProgressDialog activityIndicator = null;

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (action.equals("show")) {
			String text = args.getString(0);
			show(text);
			callbackContext.success();
			return true;
		} else if (action.equals("hide")) {
			hide();
			callbackContext.success();
			return true;
		}else if (action.equals("alert")) {
            alert(args.getString(0), args.getString(1), args.getString(2), callbackContext);
            return true;
        }

		return false;
	}

	/**
	 * This show the ProgressDialog
	 * @param text - Message to display in the Progress Dialog
	 */
	public void show(String text) {
		activityIndicator = ProgressDialog.show(this.cordova.getActivity(), "", text);
	}

	/**
	 * This hide the ProgressDialog
	 */
	public void hide() {
		if (activityIndicator != null) {
			activityIndicator.dismiss();
			activityIndicator = null;
		}
	}

	public synchronized void alert(final String message, final String title, final String buttonLabel, final CallbackContext callbackContext) {

	        final CordovaInterface cordova = this.cordova;

	        Runnable runnable = new Runnable() {
	            public void run() {

	                AlertDialog.Builder dlg = new AlertDialog.Builder(cordova.getActivity());
	                dlg.setMessage(message);
	                dlg.setTitle(title);
	                dlg.setCancelable(true);
	                dlg.setPositiveButton(buttonLabel,
	                        new AlertDialog.OnClickListener() {
	                            public void onClick(DialogInterface dialog, int which) {
	                                dialog.dismiss();
	                                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, 0));
	                            }
	                        });
	                dlg.setOnCancelListener(new AlertDialog.OnCancelListener() {
	                    public void onCancel(DialogInterface dialog)
	                    {
	                        dialog.dismiss();
	                        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, 0));
	                    }
	                });

	                dlg.create();
	                dlg.show();
	            };
	        };
	        this.cordova.getActivity().runOnUiThread(runnable);
	    }




















}