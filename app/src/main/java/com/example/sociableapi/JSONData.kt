package com.example.sociableapi

import android.os.AsyncTask
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class JSONData(private val fragment: RepositoriesFragment) : AsyncTask<String, Void, String>() {

    override fun doInBackground(vararg urls: String?): String {
        val url = URL(urls[0])
        val httpURLConnection = url.openConnection() as HttpURLConnection
        val inputStream: InputStream = httpURLConnection.inputStream
        val br = BufferedReader(InputStreamReader(inputStream))

        return br.readText()
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)

        var repositories: ArrayList<Repository> = ArrayList()

        val root = JSONArray(result)
        for(i in 0 until root.length()) {
            val objRepo: JSONObject = root.getJSONObject(i)
            var repo: Repository = Repository(

                author = objRepo.getString("author"),
                title = objRepo.getString("name"),
                url = objRepo.getString("url"),
                description = objRepo.getString("description"),
                language = objRepo.getString("name"), //no value for language hatası geliyor
                stars = objRepo.getInt("stars"),
                forks = objRepo.getInt("forks"),
                currentPeriodStars = objRepo.getInt("currentPeriodStars"),
                user = getUserFromJSONObject(objRepo)
            )
            repositories.add(repo)
        }
        fragment.downloadFinished(repositories)
    }

    private fun getUserFromJSONObject(objRepo: JSONObject): User {
        val userArray: JSONArray = objRepo.getJSONArray("builtBy")
        if(userArray.length() != 0) {
            val objUser: JSONObject = userArray.getJSONObject(0)
            return User(
                name = objUser.getString("username"),
                avatar = objUser.getString("avatar"),
                href = objUser.getString("href")
            )
        }
        return DEFAULT_USER
    }
}