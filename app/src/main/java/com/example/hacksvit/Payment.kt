import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hacksvit.R
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import org.json.JSONObject

class Payment : AppCompatActivity(),PaymentResultListener {
    lateinit var razorpay:ImageView
    lateinit var payment_editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        razorpay = findViewById(R.id.razorPay_imageView)
        payment_editText = findViewById(R.id.amount_editText)

        listener()
    }

    private fun startPayment() {
        val activity: Activity = this
        val co = Checkout()

        try {
            val options = JSONObject()
            options.put("name", "Yati Yamaha")
            options.put("description", "Service Charge")
            //You can omit the image option to fetch the image from dashboard
            options.put("image", "http://yatiyamaha.com/images/yati-logo.png")
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            val payment: String = payment_editText.getText().toString()
            var total = payment.toDouble()
            total = total * 100
            options.put("amount", total)

            val preFill = JSONObject()
            preFill.put("email", " ")
            preFill.put("contact", " ")

            options.put("prefill", preFill)
            co.open(activity, options)
        }catch (e: Exception){
            Toast.makeText(activity, "Error in payment: " + e.message, Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    override fun onPaymentSuccess(p0: String?) {
        Toast.makeText(this, "Payment Successfully:", Toast.LENGTH_LONG).show()
    }

    override fun onPaymentError(p0: Int, p1: String?) {
        Toast.makeText(this, "Error in payment: ", Toast.LENGTH_LONG).show()
    }

    private fun listener(){
        razorpay.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if (payment_editText.getText().toString().equals("")) {
                    Toast.makeText(this@Payment, "Please fill payment", Toast.LENGTH_LONG).show()
                    return
                }
                startPayment()
            }
        })
    }

}