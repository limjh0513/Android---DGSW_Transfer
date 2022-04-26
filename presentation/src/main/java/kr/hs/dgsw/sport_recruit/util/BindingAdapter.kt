package kr.hs.dgsw.sport_recruit.util

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import kr.hs.dgsw.domain.model.DetailPost
import kr.hs.dgsw.domain.model.Post
import kr.hs.dgsw.domain.model.User
import kr.hs.dgsw.sport_recruit.R
import kotlin.math.roundToInt

object BindingAdapter {

    @BindingAdapter("app:setGrade")
    @JvmStatic
    fun setGradeTv(textView: TextView, user: User) {
        textView.text = "${user.grade}-${user.room}-${user.number}"
    }

    @BindingAdapter("app:setImage")
    @JvmStatic
    fun setImage(circleImageView: CircleImageView, url: String) {
        Glide.with(circleImageView.context).load(url).error(R.drawable.ic_humen)
            .into(circleImageView)
    }

    @SuppressLint("ResourceAsColor")
    @BindingAdapter("app:setPersonalForDetail")
    @JvmStatic
    fun setDetailPersonal(textView: TextView, post: DetailPost){
        when(((post.currentPersonal / post.personal.toFloat()) * 100).roundToInt()){
            in 0..33 -> textView.setTextColor(R.color.color_safe)
            in 34..66 -> textView.setTextColor(R.color.color_caution)
            in 67..99 -> textView.setTextColor(R.color.color_danger)
            else -> textView.setTextColor(R.color.color_end)
        }

        textView.text = "${post.currentPersonal}/${post.personal}"
    }

    @SuppressLint("ResourceAsColor")
    @BindingAdapter("app:setPersonalForPost")
    @JvmStatic
    fun setPersonal(textView: TextView, post: Post){
        when(((post.currentPersonal / post.personal.toFloat()) * 100).roundToInt()){
            in 0..33 -> textView.setTextColor(R.color.color_safe)
            in 34..66 -> textView.setTextColor(R.color.color_caution)
            in 67..99 -> textView.setTextColor(R.color.color_danger)
            else -> textView.setTextColor(R.color.color_end)
        }

        textView.text = "${post.currentPersonal}/${post.personal}"
    }
}