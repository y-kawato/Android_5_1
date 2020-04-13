package jp.co.stv_tech.android_5_1

import android.app.LauncherActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvMenu = findViewById<ListView>(R.id.lvMenu)

        var menulist = mutableListOf<String>("唐揚げ定食","ハンバーグ定食","生姜焼き定食","ステーキ定食","野菜炒め定食")

        val adapter = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1,menulist)
        lvMenu.adapter = adapter

        lvMenu.onItemClickListener = ListItemClickListener()
    }

    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id:Long) {

            val dialogFragment = OrderConfirmDialogFragment()

            dialogFragment.show(supportFragmentManager, "OrderConfirmDialogFragment")

        }
    }
}
