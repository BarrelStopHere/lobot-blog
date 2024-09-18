echo #######################
echo ##### begin copy ######
echo #######################

echo ###### copy admin ########
copy .\conf\prod\admin\application.yml ..\..\admin\src\main\resources\
copy .\conf\prod\admin\bootstrap.yml ..\..\admin\src\main\resources\


echo ###### copy gateway ########
copy .\conf\prod\gateway\application.yml ..\..\gateway\src\main\resources\
copy .\conf\prod\gateway\bootstrap.yml ..\..\gateway\src\main\resources\


echo ###### copy monitor ########
copy .\conf\prod\monitor\application.yml ..\..\monitor\src\main\resources\
copy .\conf\prod\monitor\bootstrap.yml ..\..\monitor\src\main\resources\


echo ###### copy picture ########
copy .\conf\prod\picture\application.yml ..\..\picture\src\main\resources\
copy .\conf\prod\picture\bootstrap.yml ..\..\picture\src\main\resources\


echo ###### copy search ########
copy .\conf\prod\search\application.yml ..\..\search\src\main\resources\
copy .\conf\prod\search\bootstrap.yml ..\..\search\src\main\resources\


echo ###### copy sms ########
copy .\conf\prod\sms\application.yml ..\..\sms\src\main\resources\
copy .\conf\prod\sms\bootstrap.yml ..\..\sms\src\main\resources\


echo ###### copy spider ########
copy .\conf\prod\spider\application.yml ..\..\spider\src\main\resources\
copy .\conf\prod\spider\bootstrap.yml ..\..\spider\src\main\resources\


echo ###### copy web ########
copy .\conf\prod\web\application.yml ..\..\web\src\main\resources\
copy .\conf\prod\web\bootstrap.yml ..\..\web\src\main\resources\
