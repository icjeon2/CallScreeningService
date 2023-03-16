/*
 
*/

/**
  request your app for ROLE_CALL_SCREENING
*/
private fun requestCallScreeningRole(){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        val roleManager = getSystemService(ROLE_SERVICE) as RoleManager
        val intent = roleManager.createRequestRoleIntent(RoleManager.ROLE_CALL_SCREENING)
        startActivityForResult(intent, REQUEST_CODE_CALLSCREENING_ROLE)
    }
}


override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    Timber.d("onActivityResult -> requestCode: $requestCode, resultCode: $resultCode, data: $data")
    super.onActivityResult(requestCode, resultCode, data)

    if (requestCode == REQUEST_CODE_CALLSCREENING_ROLE) {
        if (resultCode != android.app.Activity.RESULT_OK) {
          // Your app is not the call screening app 
          
            alert {
                message = "please set this app for call screening app"
                okButton {
                    requestCallScreeningRole()
                }
                negativeButton("cancel") {
                   
                }
            }.show()
            

        }else{
          // Your app is now the call screening app
        }
        return
    }
}
