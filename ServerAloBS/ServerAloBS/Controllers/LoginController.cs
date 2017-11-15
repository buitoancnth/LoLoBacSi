using ServerAloBS.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ServerAloBS.Controllers
{
    public class LoginController : ApiController
    {
        private AloModel db = new AloModel();

        // GET: api/BacSis
        [HttpPost]
        public int Login(LoginModel login)
        {
            BacSi bs=null;
            BenhNhan bn = null;
            if (login.isBacSi)
                bs = db.BacSis.SingleOrDefault(x => (x.Email == login.Email && x.MatKhau== login.MatKhau));
            else
                bn = db.BenhNhans.SingleOrDefault(x => (x.Email == login.Email && x.MatKhau == login.MatKhau));
            if (bs != null) return 2;
            if (bn != null) return 1;
            return 0;
        }
    }
}
