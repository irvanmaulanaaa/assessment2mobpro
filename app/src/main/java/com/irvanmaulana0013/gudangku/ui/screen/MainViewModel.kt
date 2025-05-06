package com.irvanmaulana0013.gudangku.ui.screen

import androidx.lifecycle.ViewModel
import com.irvanmaulana0013.gudangku.model.Barang

class MainViewModel : ViewModel() {
    val data = listOf(
        Barang(
            1,
            "Sepeda",
            "Kendaraan",
            "2",
            "Sepeda bekas yang sudah terbengkalai kurang lebih selama" +
                    " 5 tahun yang lalu.",
            "2025-04-07 10:43:59"
        ),
        Barang(
            2,
            "Kulkas",
            "Elektronik",
            "1",
            "Kulkas dua pintu yang sudah tidak dingin lagi dan sering " +
                    "mengeluarkan bunyi aneh dari bagian belakangnya. " +
                    "Rak di dalamnya juga sudah pecah dan pintunya tidak bisa tertutup rapat.",
            "2025-04-08 14:22:10"
        ),
        Barang(
            3,
            "TV",
            "Elektronik",
            "3",
            "Televisi tabung jadul dengan layar 21 inci yang sudah mulai buram " +
                    "dan warnanya tidak merata.",
            "2025-04-09 09:15:45"
        ),
        Barang(
            4,
            "Meja Belajar",
            "Perabotan Rumah Tangga",
            "2",
            "Meja belajar dari kayu lapis yang permukaannya " +
                    "penuh dengan coretan pensil, pulpen, dan bekas lem. " +
                    "Lacinya macet dan kaki meja sudah sedikit goyah karena termakan usia.",
            "2025-04-09 11:50:33"
        ),
        Barang(
            5,
            "Kipas Angin",
            "Elektronik",
            "1",
            "Kipas angin model duduk yang baling-balingnya sudah patah sebagian. " +
                    "Mesin penggeraknya berbunyi keras saat dinyalakan dan kadang " +
                    "tidak berputar sama sekali.",
            "2025-04-10 13:03:21"
        ),
        Barang(
            6,
            "Printer",
            "Elektronik",
            "3",
            "Printer yang dulunya sering digunakan untuk mencetak dokumen kuliah. " +
                    "Sekarang hasil cetaknya buram, tintanya sering tidak keluar, " +
                    "dan kertas sering tersangkut.",
            "2025-04-11 08:27:59"
        ),
        Barang(
            7,
            "Kursi Plastik",
            "Perabotan Rumah Tangga",
            "2",
            "Kursi plastik berwarna biru dengan bagian dudukan " +
                    "yang sudah retak memanjang. Meski masih bisa digunakan," +
                    " terasa tidak stabil saat diduduki.",
            "2025-04-11 16:41:00"
        ),
        Barang(
            8,
            "Lemari Pakaian",
            "Perabotan Rumah Tangga",
            "1",
            "Lemari pakaian kayu dua pintu yang menjadi andalan di kamar utama. " +
                    "Salah satu pintunya sudah longgar dan engselnya nyaris lepas.",
            "2025-04-12 10:17:42"
        ),
        Barang(
            9,
            "Kompor Gas",
            "Peralatan Rumah Tangga",
            "3",
            "Kompor gas dua tungku dengan salah satu tungku " +
                    "yang tidak mau menyala lagi. Permukaannya berkarat karena " +
                    "sering terkena tumpahan air dan minyak.",
            "2025-04-12 18:05:37"
        ),
        Barang(
            10,
            "Dispenser",
            "Elektronik",
            "1",
            "Dispenser air yang fungsi pemanasnya sudah mati total " +
                    "dan bagian pendinginnya hanya membuat air menjadi sedikit lebih dingin.",
            "2025-04-13 12:40:29"
        )
    )

    fun getBarang(id: Long): Barang? {
        return data.find { it.id == id }
    }
}