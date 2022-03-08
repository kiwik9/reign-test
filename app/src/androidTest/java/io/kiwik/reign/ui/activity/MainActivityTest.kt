package io.kiwik.reign.ui.activity

import androidx.recyclerview.widget.RecyclerView
import androidx.test.ext.junit.rules.ActivityScenarioRule
import io.kiwik.reign.R
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @Rule
    @JvmField
    var activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun recyclerViewTest() {
        activity.scenario.onActivity {
            val recyclerView = it.findViewById<RecyclerView>(R.id.rv_post)
            assert(recyclerView.adapter?.itemCount ?: 0 > 0)
        }
    }
}