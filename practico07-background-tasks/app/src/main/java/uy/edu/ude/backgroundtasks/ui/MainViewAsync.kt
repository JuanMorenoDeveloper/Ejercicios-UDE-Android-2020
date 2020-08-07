package uy.edu.ude.backgroundtasks.ui

interface MainViewAsync {
    fun showBar()
    fun incrementProgress(progress: Int)
    fun hideBar()
}