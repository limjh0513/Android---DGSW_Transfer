package kr.hs.dgsw.sport_recruit.util

import android.annotation.SuppressLint
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import kr.hs.dgsw.domain.model.*
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

    @BindingAdapter("setGradeName")
    @JvmStatic
    fun setGradeNameTv(textView: TextView, apply: Apply?) {
        if (apply != null) {
            textView.text = "${apply.grade}-${apply.room}-${apply.number} ${apply.name}"
        }
    }

    @BindingAdapter("setImage")
    @JvmStatic
    fun setImage(circleImageView: CircleImageView, url: String?) {
        if (url != null) {
            Glide.with(circleImageView.context).load(url).placeholder(R.drawable.ic_humen)
                .error(R.drawable.ic_humen)
                .into(circleImageView)
        }
    }

    @SuppressLint("ResourceAsColor")
    @BindingAdapter("setPersonalForDetail")
    @JvmStatic
    fun setDetailPersonal(textView: TextView, post: DetailPost?) {
        if (post != null) {
            if (post.state < 2) {
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
            } else {
                textView.setTextColor(ContextCompat.getColor(textView.context,
                    R.color.color_end))
                textView.text = "-종료-"
            }
        }
    }

    @SuppressLint("ResourceAsColor")
    @BindingAdapter("setPersonalForPost")
    @JvmStatic
    fun setPersonal(textView: TextView, post: Post) {

        if (post.state < 2) {
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
        } else {
            textView.setTextColor(ContextCompat.getColor(textView.context,
                R.color.color_end))
        }

        textView.text = "${post.currentPersonal}/${post.personal}"
    }

    @SuppressLint("ResourceAsColor")
    @BindingAdapter("setPersonalMyApply")
    @JvmStatic
    fun setPersonalMyApply(textView: TextView, item: MyAllApply) {

        if (item.postState < 2) {
            when (((item.currentPersonnel / item.personnel.toFloat()) * 100).roundToInt()) {
                in 0..33 -> textView.setTextColor(ContextCompat.getColor(textView.context,
                    R.color.color_safe))
                in 34..66 -> textView.setTextColor(ContextCompat.getColor(textView.context,
                    R.color.color_caution))
                in 67..99 -> textView.setTextColor(ContextCompat.getColor(textView.context,
                    R.color.color_danger))
                else -> textView.setTextColor(ContextCompat.getColor(textView.context,
                    R.color.color_end))
            }
        } else {
            textView.setTextColor(ContextCompat.getColor(textView.context,
                R.color.color_end))
        }

        textView.text = "${item.currentPersonnel}/${item.personnel}"
    }

    @SuppressLint("ResourceAsColor")
    @BindingAdapter("setApplyState")
    @JvmStatic
    fun setApplyState(textView: TextView, state: Int) {

        if (state == 0) {
            textView.setTextColor(ContextCompat.getColor(textView.context, R.color.color_safe))
            textView.text = "신청 완료"
        } else {
            textView.setTextColor(ContextCompat.getColor(textView.context, R.color.color_danger))
            textView.text = "신청 취소"
        }
    }

    @BindingAdapter("setCategoryText")
    @JvmStatic
    fun setCategoryText(textView: TextView, category: Int?) {
        if (category != null) {
            textView.text = "종목 - ${categoryToString(category)}"
        }
    }

    @BindingAdapter("sirenVisible")
    @JvmStatic
    fun setSirenVisible(imageView: ImageView, state: Int) {
        imageView.isVisible = state == 1
    }

    @BindingAdapter("endVisible")
    @JvmStatic
    fun setEndVisible(textView: TextView, state: Int) {
        textView.isVisible = state == 2
    }

    @BindingAdapter("personalVisible")
    @JvmStatic
    fun setpersonalVisible(textView: TextView, state: Int) {
        textView.isVisible = state < 2
    }

    @BindingAdapter("setApplyBtn")
    @JvmStatic
    fun setApplyBtn(button: Button, applyState: Int) {
        when (applyState) {
            -1 -> { // 신청 X
                button.background = ContextCompat.getDrawable(button.context,
                    R.drawable.background_button_completion)
                button.text = "참가 신청"
            }
            0 -> { // 신청 완료
                button.background =
                    ContextCompat.getDrawable(button.context, R.drawable.background_button_cancel)
                button.text = "참가 취소"
            }
            1 -> { // 신청 취소
                button.background = ContextCompat.getDrawable(button.context,
                    R.drawable.background_button_completion)
                button.text = "참가 신청"
            }
            2 -> { //내가 작성한 게시글
                button.background =
                    ContextCompat.getDrawable(button.context, R.drawable.background_button_closing)
                button.text = "조기 마감"
            }
        }
    }

    @BindingAdapter("setDetailTime")
    @JvmStatic
    fun setDetailTime(textView: TextView, time: String?) {
        if (time != null) {
            val splitted = time.split(" ")
            val d = splitted[0].split("-")
            val t = splitted[1].split(":")

            textView.text = "${d[0]}년 ${d[1]}월 ${d[2]}일 ${t[0]}시 ${t[1]}분"
        }
    }
}