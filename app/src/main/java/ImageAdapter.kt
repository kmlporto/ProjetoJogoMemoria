import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.projetojododamemoria.R

class ImageAdapter: BaseAdapter {
    private var context: Context? = null

    constructor(context: Context){
        this.context = context
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return 16
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var imgView: ImageView
        if (convertView == null){
            imgView = ImageView(this.context)
            val lp = LinearLayout.LayoutParams(
                210,
                250
            )
            lp.setMargins(100, 100, 100, 100)
            imgView.setLayoutParams(lp)
            imgView.setPadding(10, 10, 10, 10)
            imgView.setScaleType(ImageView.ScaleType.FIT_XY)
            imgView.setImageResource(R.drawable.hidden)
        }else{
            imgView = convertView as ImageView
            imgView.setImageResource(R.drawable.hidden)
        }
        return imgView
    }

}
