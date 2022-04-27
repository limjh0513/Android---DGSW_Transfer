package kr.hs.dgsw.sport_recruit.util

import android.annotation.SuppressLint
import android.util.Log
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import kr.hs.dgsw.domain.model.DetailPost
import kr.hs.dgsw.domain.model.Post
import kr.hs.dgsw.domain.model.User
import kr.hs.dgsw.sport_recruit.R
import kotlin.math.roundToInt

object BindingAdapter {

    @BindingAdapter("setGrade")
    @JvmStatic
    fun setGradeTv(textView: TextView, user: User?) {
        if (user != null) {
            textView.text = "${user.grade}-${user.room}-${user.number}"
        }
    }

    @BindingAdapter("setImage")
    @JvmStatic
    fun setImage(circleImageView: CircleImageView, url: String?) {
        if (url != null) {
            Glide.with(circleImageView.context).load(url).error(R.drawable.ic_humen)
                .into(circleImageView)
        }
    }

    @SuppressLint("ResourceAsColor")
    @BindingAdapter("setPersonalForDetail")
    @JvmStatic
    fun setDetailPersonal(textView: TextView, post: DetailPost?) {
        if (post != null) {
            Log.e("asdf",
                "${((post.currentPersonal / post.personal.toFloat()) * 100).roundToInt()}")

            when (((post.currentPersonal / post.personal.toFloat()) * 100).roundToInt()) {
                in 0..33 -> textView.setTextColor(ContextCompat.getColor(textView.context,
                    R.color.color_safe))
                in 34..66 -> textView.setTextColor(ContextCompat.getColor(textView.context,
                    R.color.color_caution))
                in 67..99 -> textView.setTextColor(ContextCompat.getColor(textView.context,
                    R.color.color_danger))
                else -> textView.setTextColor(ContextCompat.getColor(textView.context,
                    R.color.color_end))
            }

            textView.text = "${post.currentPersonal}/${post.personal}"
        }
    }

    @SuppressLint("ResourceAsColor")
    @BindingAdapter("setPersonalForPost")
    @JvmStatic
    fun setPersonal(textView: TextView, post: Post) {
        Log.e("asdf", "${((post.currentPersonal / post.personal.toFloat()) * 100).roundToInt()}")

        when (((post.currentPersonal / post.personal.toFloat()) * 100).roundToInt()) {
            in 0..33 -> textView.setTextColor(ContextCompat.getColor(textView.context,
                R.color.color_safe))
            in 34..66 -> textView.setTextColor(ContextCompat.getColor(textView.context,
                R.color.color_caution))
            in 67..99 -> textView.setTextColor(ContextCompat.getColor(textView.context,
                R.color.color_danger))
            else -> textView.setTextColor(ContextCompat.getColor(textView.context,
                R.color.color_end))
        }

        textView.text = "${post.currentPersonal}/${post.personal}"
    }

    @BindingAdapter("setCategoryText")
    @JvmStatic
    fun setCategoryText(textView: TextView, category: Int?) {
        if (category != null) {
            textView.text = categoryToString(category)
        }
    }
}