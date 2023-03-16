import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.provider.Settings
import android.telecom.Call
import android.telecom.CallScreeningService
import android.telecom.InCallService
import android.telephony.TelephonyManager
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import org.jetbrains.anko.*
import timber.log.Timber
import java.util.*

/*
  this service bind when your phone on call state.
*/

@RequiresApi(Build.VERSION_CODES.N)
class MyCallScreeningService : CallScreeningService() {
  
  //when your phone state is outgoing or incoming call state, this function be called
    override fun onScreenCall(callDetails: Call.Details) {
      
      /*
        you can reject or respond using respond builder
      */
        val response = CallResponse.Builder()
        respondToCall(callDetails, response.build())

        
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) return

        // call direction incoming or outgoing
        val isIncomming = callDetails.callDirection == Call.Details.DIRECTION_INCOMING
        Timber.d("isIncomming $isIncomming")

        if(!isIncomming) return

      // incoming call number. who is call?
        val incomingNumber = callDetails.handle.schemeSpecificPart

    }
}
