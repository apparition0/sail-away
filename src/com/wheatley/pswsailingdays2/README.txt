
If we do this, the number picker gets simple + and -

<activity android:name=".ActivityName"
    android:label="@string/app_name"
    android:theme="@android:style/Theme.Black.NoTitleBar.Fullscreen">
</activity>

WUnderground f2e53d68fe83590a MySailingNotifier1
http://api.wunderground.com/api/f2e53d68fe83590a/conditions/q/TX/Dallas.json
http://api.wunderground.com/api/f2e53d68fe83590a/forecast10day/q/TX/Dallas.json

		/*
		 * try { // read the json file FileReader reader = new
		 * FileReader(filePath);
		 * 
		 * JSONParser jsonParser = new JSONParser(); JSONObject jsonObject =
		 * (JSONObject) jsonParser.parse(reader);
		 * 
		 * // get a String from the JSON object String firstName = (String)
		 * jsonObject.get("firstname"); System.out.println("The first name is: "
		 * + firstName);
		 * 
		 * // get a number from the JSON object long id = (long)
		 * jsonObject.get("id"); System.out.println("The id is: " + id);
		 * 
		 * // get an array from the JSON object JSONArray lang= (JSONArray)
		 * jsonObject.get("languages");
		 * 
		 * // take the elements of the json array for(int i=0; i<lang.size();
		 * i++){ System.out.println("The " + i +
		 * " element of the array: "+lang.get(i)); } Iterator i =
		 * lang.iterator();
		 * 
		 * // take each value from the json array separately while (i.hasNext())
		 * { JSONObject innerObj = (JSONObject) i.next();
		 * System.out.println("language "+ innerObj.get("lang") + " with level "
		 * + innerObj.get("knowledge")); } // handle a structure into the json
		 * object JSONObject structure = (JSONObject) jsonObject.get("job");
		 * System.out.println("Into job structure, name: " +
		 * structure.get("name"));
		 * 
		 * } catch (FileNotFoundException ex) { ex.printStackTrace(); } catch
		 * (IOException ex) { ex.printStackTrace(); } catch (ParseException ex)
		 * { ex.printStackTrace(); } catch (NullPointerException ex) {
		 * ex.printStackTrace(); }
		 * 
		 * }
		 */
