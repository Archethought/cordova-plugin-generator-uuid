/*** This is the Android Java Source File ***/
package com.archethought.cordovaplugins.generators;

import org.apache.cordova.*;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.util.UUID;

/***
 * This class called by CordovaActivity to store strings in a circular buffer.
 ***/
public class uuid extends CordovaPlugin {
    /***
     * Class Variables
     ***/
    // private int max;
    
    /*** Cordova Magic Functions ***/
    
    @Override
    public void initialize( final CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        
        // Initialization of the goodies.
        // this.max = 300;
    }
    
    @Override
    public boolean execute( String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        // These if statements call the actual functions.  There must be one for each public function.
        // randomUUID function
        if( "randomUUID".equals( action)) {
            this.randomUUID( callbackContext);
            return true;
        }
        
        // This is needed to be PC ( programmatically correct).
        return false;
    }
    
    // Make another constructor here that allows a number of items to be set.
    
    /*** PUBLIC FUNCTIONS ***/
    
    /***
     * randomUUID function
     *   Generate a random UUID and return a JSONObject containg a string representing the UUID.
     ***/
    public void randomUUID( CallbackContext callbackContext) {
        // Create a random UUID
        UUID generatedUUID = UUID.randomUUID();
        // Build the JSONObject for return
        JSONObject generatedJSON = this.jsonify( generatedUUID);
        // Return the JSONObject if the JSONObject is not empty, otherwise call the error callback.
        // An empty JSONObject should never happen here.
        if( generatedJSON.length() > 0) {
            callbackContext.success( generatedJSON);
        } else {
            callbackContext.error();
        }
        return;
    }
    
    /*** PRIVATE FUNCTIONS ***/
    
    /***
     * jsonify function
     *   Return a JSONObject containing the UUID information
     ***/
    private JSONObject jsonify( UUID inputUUID) {
        // Create a JSONObject
        JSONObject outputJSON = new JSONObject();
        // Copy the needed values into the JSONObject
        try {
            outputJSON.put( "string", inputUUID.toString());
            outputJSON.put( "mostSignificantBits", inputUUID.getMostSignificantBits());
            outputJSON.put( "leastSignificantBits", inputUUID.getLeastSignificantBits());
            outputJSON.put( "version", inputUUID.version());
            outputJSON.put( "variant", inputUUID.variant());
        } catch {
            // If the puts fail, return an empty JSONObject
            outputJSON = new JSONObject();
        }
        // Return the JSONObject
        return( outputJSON);
    }
}
