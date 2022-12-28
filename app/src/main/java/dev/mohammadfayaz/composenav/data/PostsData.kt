package dev.mohammadfayaz.composenav.data

import java.io.IOException
import java.io.InputStream
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject

object PostsData {
  val data = mutableListOf<PostModel>()

  suspend fun loadData(inputStream: InputStream) {
    withContext(Dispatchers.IO) {
      try {
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val jsonArray = JSONArray(String(buffer))

        for (i in 0 until jsonArray.length()) {
          data.add(jsonToPostModel(jsonArray.getJSONObject(i)))
        }
      } catch (ex: IOException) {
        throw ex
      }
    }
  }

  private fun jsonToPostModel(obj: JSONObject): PostModel {
    return PostModel(
      id = obj.getInt("id"),
      createdAt = obj.getString("createdAt"),
      image = obj.getString("image"),
      username = obj.getString("username"),
      avatar = obj.getString("avatar"),
      likes = obj.getInt("likes"),
      caption = obj.getString("caption")
    )
  }
}
