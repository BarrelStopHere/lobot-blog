echo #######################
echo ##### begin copy ######
echo #######################

echo ###### copy admin ########
copy .\conf\local\admin\application.yml ..\..\admin\src\main\resources\
copy .\conf\local\admin\bootstrap.yml ..\..\admin\src\main\resources\


echo ###### copy gateway ########
copy .\conf\local\gateway\application.yml ..\..\gateway\src\main\resources\
copy .\conf\local\gateway\bootstrap.yml ..\..\gateway\src\main\resources\


echo ###### copy monitor ########
copy .\conf\local\monitor\application.yml ..\..\monitor\src\main\resources\
copy .\conf\local\monitor\bootstrap.yml ..\..\monitor\src\main\resources\


echo ###### copy picture ########
copy .\conf\local\picture\application.yml ..\..\picture\src\main\resources\
copy .\conf\local\picture\bootstrap.yml ..\..\picture\src\main\resources\


echo ###### copy search ########
copy .\conf\local\search\application.yml ..\..\search\src\main\resources\
copy .\conf\local\search\bootstrap.yml ..\..\search\src\main\resources\


echo ###### copy sms ########
copy .\conf\local\sms\application.yml ..\..\sms\src\main\resources\
copy .\conf\local\sms\bootstrap.yml ..\..\sms\src\main\resources\


echo ###### copy spider ########
copy .\conf\local\spider\application.yml ..\..\spider\src\main\resources\
copy .\conf\local\spider\bootstrap.yml ..\..\spider\src\main\resources\


echo ###### copy web ########
copy .\conf\local\web\application.yml ..\..\web\src\main\resources\
copy .\conf\local\web\bootstrap.yml ..\..\web\src\main\resources\
