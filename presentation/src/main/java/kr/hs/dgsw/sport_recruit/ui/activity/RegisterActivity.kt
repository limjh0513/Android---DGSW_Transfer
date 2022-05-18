package kr.hs.dgsw.sport_recruit.ui.activity

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.sport_recruit.R
import kr.hs.dgsw.sport_recruit.base.BaseActivity
import kr.hs.dgsw.sport_recruit.databinding.ActivityRegisterBinding
import kr.hs.dgsw.sport_recruit.util.*
import kr.hs.dgsw.sport_recruit.viewmodel.RegisterViewModel

@AndroidEntryPoint
class RegisterActivity : BaseActivity<ActivityRegisterBinding, RegisterViewModel>() {
    override val mViewModel: RegisterViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_register

    override fun observeViewModel() {
        with(mViewModel) {
            onSuccessRegister.observe(this@RegisterActivity, Observer {
                toast("회원가입 성공!")
                finish()
            })

            onErrorEvent.observe(this@RegisterActivity, Observer {
                toast("${it.message}")
                testLog("$it")
            })
        }
    }

    fun onClickRegisterBtn() {
        with(mViewModel) {
            if (id.value?.lengthCheck(4) == true && pw?.value
                    ?.lengthCheck(4) == true && name.value
                    ?.lengthCheck(2) == true && grade.value?.integerNotOver(3) == true && room.value
                    ?.integerNotOver(4) == true && number.value?.integerNotOver(20) == true
            ) {
                register()
            } else {
                toast("입력 양식에 맞게 모두 입력 후 회원가입 버튼을 눌러주세요.")
            }
        }
    }
}