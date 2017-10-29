namespace ServerAloBS.Models
{
    using System;
    using System.Data.Entity;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Linq;

    public partial class AloModel : DbContext
    {
        public AloModel()
            : base("name=AloModel")
        {
        }

        public virtual DbSet<BacSi> BacSis { get; set; }
        public virtual DbSet<BenhNhan> BenhNhans { get; set; }
        public virtual DbSet<ChuyenKhoa> ChuyenKhoas { get; set; }
        public virtual DbSet<TinNhan> TinNhans { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
        }
    }
}
