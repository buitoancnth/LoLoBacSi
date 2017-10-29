namespace ServerAloBS.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("TinNhan")]
    public partial class TinNhan
    {
        [Key]
        public int IDTinNhan { get; set; }

        public int? IDBacSi { get; set; }

        public int? IDBenhNhan { get; set; }

        [Column(TypeName = "ntext")]
        public string NoiDung { get; set; }

        public DateTime? ThoiGian { get; set; }

        public bool? Chieu { get; set; }

       // public virtual BacSi BacSi { get; set; }

       // public virtual BenhNhan BenhNhan { get; set; }
    }
}
