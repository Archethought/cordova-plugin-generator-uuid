/*** This is the javascript interface that the app uses. ***/
//
// Use jsdoc to generate documentation.

// The following line causes a jsdoc error.
// Use the jsdoc option -l to ignore the error.
var exec = cordova.require('cordova/exec');

/** @module com.archethought.cordovaplugins.generators.uuid */

/** Generate a random UUID ( type 4)
* @param {resultCallback} resultCallback - The function that will handle the result.
* @example
generator_uuid.randomUUID(
    function( uuid) {
        console.log( 'Random UUID String: ' + uuid.string);
        console.log( 'Random UUID Most Significant Bits: ' + uuid.mostSignificantBits);
        console.log( 'Random UUID Least Significant Bits: ' + uuid.leastSignificantBits);
        console.log( 'Random UUID Version Number: ' + uuid.version);
        console.log( 'Random UUID Variant Number: ' + uuid.variant);
    },
    function( error) {
        console.log( 'ERROR: Failed to generate a UUID: ' + error);
    }
);
*/
exports.randomUUID = function( resultCallback, errorCallback) {
    exec( resultCallback, errorCallback, 'generator_uuid', 'randomUUID', []);
};
