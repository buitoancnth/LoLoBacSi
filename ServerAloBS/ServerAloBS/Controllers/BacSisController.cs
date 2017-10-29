using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using ServerAloBS.Models;

namespace ServerAloBS.Controllers
{
    public class BacSisController : ApiController
    {
        private AloModel db = new AloModel();

        // GET: api/BacSis
        public IQueryable<BacSi> GetBacSis()
        {
            return db.BacSis;
        }

        // GET: api/BacSis/5
        [ResponseType(typeof(BacSi))]
        public IHttpActionResult GetBacSi(int id)
        {
            BacSi bacSi = db.BacSis.Find(id);
            if (bacSi == null)
            {
                return NotFound();
            }

            return Ok(bacSi);
        }

        // PUT: api/BacSis/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutBacSi(int id, BacSi bacSi)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != bacSi.IDBacSi)
            {
                return BadRequest();
            }

            db.Entry(bacSi).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!BacSiExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST: api/BacSis
        [ResponseType(typeof(BacSi))]
        public IHttpActionResult PostBacSi(BacSi bacSi)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.BacSis.Add(bacSi);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = bacSi.IDBacSi }, bacSi);
        }

        // DELETE: api/BacSis/5
        [ResponseType(typeof(BacSi))]
        public IHttpActionResult DeleteBacSi(int id)
        {
            BacSi bacSi = db.BacSis.Find(id);
            if (bacSi == null)
            {
                return NotFound();
            }

            db.BacSis.Remove(bacSi);
            db.SaveChanges();

            return Ok(bacSi);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool BacSiExists(int id)
        {
            return db.BacSis.Count(e => e.IDBacSi == id) > 0;
        }
    }
}