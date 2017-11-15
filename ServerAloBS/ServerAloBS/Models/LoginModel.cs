using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace ServerAloBS.Models
{
    public class LoginModel
    {
        [Key]
        [Display(Name = "Email đăng nhập")]
        [Required(ErrorMessage = "Bạn phải nhập Email")]
        public string Email { set; get; }

        [Required(ErrorMessage = "Bạn phải nhập mật khẩu")]
        [Display(Name = "Mật khẩu")]
        public string MatKhau { set; get; }
        [Required(ErrorMessage = "Bạn phải chọn loại tài khoản")]
        [Display(Name = "Loại tài khoản")]
        public bool isBacSi { set; get; }

    }
}