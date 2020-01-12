# StudentManager
Để có thể chạy code này thì làm theo các bước sau:  
Bước 1 : Mở database, kiểm tra lại port, password của db  
	vì hệ db lưu trữ của project  
	là mysql nên rất thông cảm mọi người check lại.  
Bước 2 : tạo database theo tên studentmanager  
Bước 3 : cách import Maven project in eclipse : https://stackoverflow.com/questions/2061094/importing-maven-project-into-eclipse  
Bước 4 : sau khi maven đã tải hết các package cần thiết thì có chạy project bằng   
	file LoginForm trong package View. account thì có form là admin + i với   
	i = 1 -> 50, password = 1. VD: admin1 - 1;  
NOTE:  
*Bạn chỉ việc tạo 1 database có tên là tùy ý xong chỉnh lại trong 2 file là SQLconnection(interative) và hibernate.cfg.xml(resources). Lưu ý code sẽ tự ren các bảng con của bài nên bạn k cần mất công tạo làm gì cho mệt.   
*Nếu các bạn dùng eclipse thì nên mở file xml bằng text, k mở bằng file xml để sửa thông tin   connect Database.  
* Hiện tại các chức năng tương đối đầy đủ và dùng được. Trừ sign up vẫn đang để xem nên làm gì   với nó.  
  
Cảm ơn đã ghé qua đây!!!  
