namespace ServerAloBS.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("LichLamViec")]
    public partial class LichLamViec
    {
        [Key]
        public int IDLichLamViec { get; set; }

        public int? IDBacSi { get; set; }

        [StringLength(100)]
        public string NgayLamViec { get; set; }

        public TimeSpan? ThoiGianBatDau { get; set; }

        public TimeSpan? ThoiGianKetThuc { get; set; }

        //public virtual BacSi BacSi { get; set; }
    }
}
