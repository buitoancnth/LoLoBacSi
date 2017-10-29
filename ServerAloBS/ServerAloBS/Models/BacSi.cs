namespace ServerAloBS.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("BacSi")]
    public partial class BacSi
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public BacSi()
        {
            LichLamViecs = new HashSet<LichLamViec>();
            TinNhans = new HashSet<TinNhan>();
        }

        [Key]
        public int IDBacSi { get; set; }

        [StringLength(100)]
        public string Ten { get; set; }

        [StringLength(200)]
        public string DiaChi { get; set; }

        [StringLength(50)]
        public string Email { get; set; }

        [StringLength(50)]
        public string MatKhau { get; set; }

        public int? SoDuTaiKhoan { get; set; }

        public int? IDChuyenKhoa { get; set; }

        [StringLength(200)]
        public string DiaChiPhongKham { get; set; }

        [StringLength(500)]
        public string GioiThieu { get; set; }

        public int? NamKinhNghiem { get; set; }

        public virtual ChuyenKhoa ChuyenKhoa { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<LichLamViec> LichLamViecs { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<TinNhan> TinNhans { get; set; }
    }
}
