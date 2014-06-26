TODO - this version
	clean up logging
	fix control flow
	fix timer intervals
	test against icon
	remove icon notification
	fix compareto code
	autoload preferences
TODO - next version
	addDagger DI
	offer storing on AWS (cloud) to share config among devices ( requires security?)
	display tomorrows weather
	timer to run at scheduled time, not just after start

AREAS:
	Activity - fix top bar to appear?
	Controller
	Day
	File
	Service
	ServiceWorker
	Timer
	View
	Weather
	WuJson
	WeatherFetchOperation

If we do this, the number picker gets simple + and -

<activity android:name=".ActivityName"
    android:label="@string/app_name"
    android:theme="@android:style/Theme.Black.NoTitleBar.Fullscreen">
</activity>

WUnderground f2e53d68fe83590a MySailingNotifier1
http://api.wunderground.com/api/f2e53d68fe83590a/conditions/q/TX/Dallas.json
http://api.wunderground.com/api/f2e53d68fe83590a/forecast10day/q/TX/Dallas.json

