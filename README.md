## TODOLIST 

### **用户管理**

- [ ] 用户注册和登录：允许用户通过邮箱和密码注册账户，并进行登录。
  - [ ] 用户注册
  - [x] 用户登录

- [ ] 用户资料管理：用户可以更新个人资料，如用户名、简介、头像等。
- [ ] 密码重置：用户可以通过邮箱重置密码。
- [x] 获取用户信息

### **视频管理**

- [ ] 视频上传：用户可以上传视频内容，包括标题、描述、视频文件。
- [ ] 视频浏览：用户可以浏览其他用户上传的视频。
- [ ] 视频编辑：视频上传者可以编辑或删除自己的视频。
  - [ ] 删除视频
  - [ ] 更新视频


### **社交互动**

- [ ] 评论功能：用户可以对视频进行评论。
  - [ ] 发表评论
  - [ ] 删除评论

- [ ] 点赞功能：用户可以对视频进行点赞。
  - [ ] 点赞
  - [ ] 取消点赞

- [ ] 关注功能：用户可以关注其他用户，以便获得关注用户的视频更新通知。
  - [ ] 关注用户
  - [ ] 取关用户


### **搜索与发现**

- [ ] 标签和分类：视频可以被标记为特定的标签或分类。（分页查询）
- [ ] 搜索功能：用户可以通过标题、描述、标签搜索视频。

### **管理员功能**

- [ ] 内容管理：管理员可以删除违规视频或评论。
- [ ] 用户管理：管理员可以管理用户账户，如禁用违规账户。
- [ ] 数据分析：管理员可以访问平台使用数据，如用户增长、视频观看统计等。

## git分支

### **功能（feature）分支**

+ 用于开发新功能的分支，通常以 `feature/` 前缀开头，后接功能描述。例如：`feature/add-login`, `feature/user-profile-enhancement`。

### **修复（bugfix）分支**

+ 用于修复bug的分支，可以使用 `bugfix/` 或 `fix/` 前缀。例如：`bugfix/login-error`, `fix/issue-123`。

### **发布（release）分支**

+ 用于准备发布版本的分支，通常使用 `release/` 前缀，后接版本号。例如：`release/1.0.0`, `release/1.1.0`。

## 数据库

### 1. 用户表 (`users`)

添加了用户状态和用户角色字段，以管理用户账户的活跃状态及角色权限。

| 字段名            | 数据类型           | 描述                                 |
| ----------------- | ------------------ | ------------------------------------ |
| user_id           | INT AUTO_INCREMENT | 用户ID，主键，自增                   |
| username          | VARCHAR(255)       | 用户名，唯一                         |
| sex               | INT                | 性别(0：女，1：男)                   |
| email             | VARCHAR(255)       | 邮箱地址，唯一                       |
| hashed_password   | VARCHAR(255)       | 加密后的密码                         |
| bio               | TEXT               | 用户简介                             |
| profile_image_url | VARCHAR(255)       | 用户头像的URL                        |
| status            | VARCHAR(50)        | 账户状态（如 "active", "suspended"） |
| role              | VARCHAR(50)        | 用户角色（如 "user", "admin"）       |
| created_at        | DATETIME           | 账户创建时间                         |
| updated_at        | DATETIME           | 账户信息最后更新时间                 |

### 2. 视频表 (`videos`) 

添加了视频状态字段，用于管理视频的公开或隐藏状态，以及视频的时长和分类标签字段。

| 字段名        | 数据类型           | 描述                               |
| ------------- | ------------------ | ---------------------------------- |
| video_id      | INT AUTO_INCREMENT | 视频ID，主键，自增                 |
| user_id       | INT                | 上传用户的ID                       |
| title         | VARCHAR(255)       | 视频标题                           |
| description   | TEXT               | 视频描述                           |
| video_url     | VARCHAR(255)       | 视频文件的URL                      |
| thumbnail_url | VARCHAR(255)       | 视频缩略图的URL                    |
| status        | VARCHAR(50)        | 视频状态（如 "public", "private"） |
| duration      | INT                | 视频时长，单位为秒                 |
| tags          | VARCHAR(255)       | 视频标签，逗号分隔                 |
| created_at    | DATETIME           | 视频上传时间                       |
| updated_at    | DATETIME           | 视频信息最后更新时间               |

### 3. 评论表 (`comments`)

添加了评论的状态字段，用于标识评论是否被隐藏或删除。

| 字段名     | 数据类型           | 描述                               |
| ---------- | ------------------ | ---------------------------------- |
| comment_id | INT AUTO_INCREMENT | 评论ID，主键，自增                 |
| video_id   | INT                | 评论对应的视频ID                   |
| user_id    | INT                | 发表评论的用户ID                   |
| text       | TEXT               | 评论内容                           |
| status     | VARCHAR(50)        | 评论状态（如 "visible", "hidden"） |
| created_at | DATETIME           | 评论发表时间                       |

### 4. 关注表 (`follows`)

优化表结构，用于表示用户间的关注关系。

| 字段名      | 数据类型           | 描述                   |
| ----------- | ------------------ | ---------------------- |
| follow_id   | INT AUTO_INCREMENT | 关注关系ID，主键，自增 |
| follower_id | INT                | 关注者（用户ID）       |
| followed_id | INT                | 被关注者（用户ID）     |
| created_at  | DATETIME           | 关注时间               |

### 5. 点赞表 (`likes`)

记录点赞信息的表，结构优化，确保每个用户对每个视频只能点赞一次。

| 字段名     | 数据类型           | 描述               |
| ---------- | ------------------ | ------------------ |
| like_id    | INT AUTO_INCREMENT | 点赞ID，主键，自增 |
| video_id   | INT                | 点赞的视频ID       |
| user_id    | INT                | 点赞的用户ID       |
| created_at | DATETIME           | 点赞时间           |

### 6. 标签表 (`tags`)

存储视频相关的标签信息，用于分类和搜索。

| 字段名      | 数据类型     | 描述               |
| ----------- | ------------ | ------------------ |
| tag_id      | INT          | 标签ID，主键，自增 |
| name        | VARCHAR(255) | 标签名称           |
| description | TEXT         | 标签描述           |
| created_at  | DATETIME     | 标签创建时间       |

### 7. 视频标签关联表 (`video_tags`)

存储视频和标签之间的多对多关系。

| 字段名     | 数据类型 | 描述               |
| ---------- | -------- | ------------------ |
| id         | INT      | 关联ID，主键，自增 |
| video_id   | INT      | 视频ID             |
| tag_id     | INT      | 标签ID             |
| created_at | DATETIME | 关联创建时间       |

### 8. 用户通知表 (`notifications`)

存储用户的通知信息，如新粉丝、评论、点赞等。

| 字段名          | 数据类型    | 描述                                       |
| --------------- | ----------- | ------------------------------------------ |
| notification_id | INT         | 通知ID，主键，自增                         |
| user_id         | INT         | 接收通知的用户ID                           |
| type            | VARCHAR(50) | 通知类型（如 "follow", "like", "comment"） |
| reference_id    | INT         | 关联的实体ID（如视频ID、评论ID等）         |
| read            | BOOLEAN     | 是否已读                                   |
| created_at      | DATETIME    | 通知发送时间                               |

### 9. 视频播放记录表 (`video_views`)

记录用户的视频观看记录。

| 字段名     | 数据类型 | 描述                   |
| ---------- | -------- | ---------------------- |
| view_id    | INT      | 观看记录ID，主键，自增 |
| video_id   | INT      | 观看的视频ID           |
| user_id    | INT      | 观看的用户ID           |
| watched_at | DATETIME | 观看时间               |

### 10. 举报表 (`reports`)

提供用户举报不当内容的功能。

| 字段名     | 数据类型    | 描述                                     |
| ---------- | ----------- | ---------------------------------------- |
| report_id  | INT         | 举报ID，主键，自增                       |
| video_id   | INT         | 被举报的视频ID                           |
| user_id    | INT         | 举报者的用户ID                           |
| reason     | TEXT        | 举报理由                                 |
| status     | VARCHAR(50) | 举报处理状态（如 "pending", "resolved"） |
| created_at | DATETIME    | 举报时间                                 |

### 11. 广告表 (`ads`)

存储广告内容信息，用于在平台上展示。

| 字段名      | 数据类型     | 描述                      |
| ----------- | ------------ | ------------------------- |
| ad_id       | INT          | 广告ID，主键，自增        |
| title       | VARCHAR(255) | 广告标题                  |
| description | TEXT         | 广告描述                  |
| url         | VARCHAR(255) | 广告链接，点击后跳转的URL |
| image_url   | VARCHAR(255) | 广告图片的URL             |
| start_date  | DATETIME     | 广告开始展示时间          |
| end_date    | DATETIME     | 广告结束展示时间          |
| created_at  | DATETIME     | 广告创建时间              |
| updated_at  | DATETIME     | 广告最后更新时间          |

### 12. 用户设置表 (`user_settings`)

存储用户个人设置信息，如隐私设置、通知设置等。

| 字段名        | 数据类型     | 描述                               |
| ------------- | ------------ | ---------------------------------- |
| setting_id    | INT          | 设置ID，主键，自增                 |
| user_id       | INT          | 用户ID                             |
| privacy       | VARCHAR(255) | 隐私设置（如 "public", "private"） |
| notifications | BOOLEAN      | 是否开启通知                       |
| theme         | VARCHAR(255) | 界面主题                           |
| language      | VARCHAR(50)  | 用户界面语言                       |
| created_at    | DATETIME     | 设置创建时间                       |
| updated_at    | DATETIME     | 设置最后更新时间                   |

### 13. 内容审核表 (`content_reviews`)

存储待审核或已审核内容的信息，用于管理不当或不适宜的视频内容。

| 字段名      | 数据类型    | 描述                                             |
| ----------- | ----------- | ------------------------------------------------ |
| review_id   | INT         | 审核ID，主键，自增                               |
| video_id    | INT         | 待审核的视频ID                                   |
| status      | VARCHAR(50) | 审核状态（如 "pending", "approved", "rejected"） |
| reviewer_id | INT         | 审核员ID                                         |
| notes       | TEXT        | 审核备注，说明审核的具体内容或原因               |
| reviewed_at | DATETIME    | 审核时间                                         |

### 14. 用户活动日志表 (`user_activity_logs`)

记录用户的关键活动，用于安全监控和行为分析。

| 字段名        | 数据类型     | 描述                                             |
| ------------- | ------------ | ------------------------------------------------ |
| log_id        | INT          | 日志ID，主键，自增                               |
| user_id       | INT          | 用户ID                                           |
| activity_type | VARCHAR(255) | 活动类型（如 "login", "logout", "video_upload"） |
| ip_address    | VARCHAR(50)  | 用户活动时的IP地址                               |
| device_info   | VARCHAR(255) | 用户使用的设备信息                               |
| created_at    | DATETIME     | 活动记录时间                                     |


### 15.管理员操作日志表 (`admin_logs`)

| 字段名    | 数据类型     | 描述               |
| --------- | ------------ | ------------------ |
| log_id    | INT          | 日志ID，主键，自增 |
| user_id   | INT          | 参照`user`表的外键 |
| action    | VARCHAR(255) | 执行的操作描述     |
| timestamp | DATETIME     | 操作发生的时间     |

## 接口信息

### 用户管理

**1. 注册用户**

- **Method:** POST

- **URL:** `/api/users/register`

- Body:

  ```json
  {
    "username": "string",
    "email": "string",
    "password": "string"
  }
  ```

- Response:

  ```json
  {
    "user_id": "int",
    "username": "string",
    "email": "string",
    "created_at": "datetime"
  }
  ```

**2. 用户登录**

- **Method:** POST

- **URL:** `/api/users/login`

- Body:

  ```json
  {
    "email": "string",
    "password": "string"
  }
  ```

- Response:

  ```json
  {
    "token": "string"
  }
  ```

**3. 获取用户信息**

- **Method:** GET

- **URL:** `/api/users/{userId}`

- Headers:

  ```makefile
  Authorization: Bearer Token
  ```
  
- Response:

  ```json
  {
    "user_id": "int",
    "username": "string",
    "email": "string",
    "bio": "string",
    "profile_image_url": "string",
    "status": "string",
    "created_at": "datetime"
  }
  ```

**4. 更新用户信息**

- **Method:** PUT

- **URL:** `/api/users/{userId}`

- Headers:

  ```makefile
  Authorization: Bearer Token
  ```

- Body:

  ```json
  {
    "email": "string",
    "username": "string",
    "sex": "int",
    "bio": "string",
    "profile_image_url": "string"
  }
  ```

- Response:

  ```json
  {
    "user_id": "int",
    "username": "string",
    "email": "string",
    "bio": "string",
    "profile_image_url": "string",
    "updated_at": "datetime"
  }
  ```

### 视频内容管理

**5. 上传视频**

- **Method:** POST

- **URL:** `/api/videos`

- Headers:

  ```makefile
  Authorization: Bearer Token
  ```

- Body:

  ```json
  {
    "title": "string",
    "description": "string",
    "video_file": "file"
  }
  ```

- Response:

  ```json
  {
    "video_id": "int",
    "title": "string",
    "description": "string",
    "video_url": "string",
    "thumbnail_url": "string",
    "status": "string",
    "created_at": "datetime"
  }
  ```

**6. 获取视频详情**

- **Method:** GET

- **URL:** `/api/videos/{videoId}`

- Response:

  ```json
  {
    "video_id": "int",
    "user_id": "int",
    "title": "string",
    "description": "string",
    "video_url": "string",
    "thumbnail_url": "string",
    "status": "string",
    "created_at": "datetime",
    "tags": "string",
    "duration": "int"
  }
  ```

**7. 更新视频信息**

- **Method:** PUT

- **URL:** `/api/videos/{videoId}`

- Headers:

  ```makefile
  Authorization: Bearer Token
  ```

- Body:

  ```json
  {
    "title": "string",
    "description": "string",
    "status": "string"
  }
  ```

- Response:

  ```json
  {
    "video_id": "int",
    "title": "string",
    "description": "string",
    "status": "string",
    "updated_at": "datetime"
  }
  ```

**8. 删除视频**

- **Method:** DELETE

- **URL:** `/api/videos/{videoId}`

- Headers:

  ```makefile
  Authorization: Bearer Token
  ```

- Response:

  ```json
  {
    "success": "boolean",
    "message": "Video deleted successfully"
  }
  ```

### 社交互动

**9. 发布评论**

- **Method:** POST

- **URL:** `/api/comments`

- Headers:

  ```makefile
  Authorization: Bearer Token
  ```

- Body:

  ```json
  {
    "video_id": "int",
    "text": "string"
  }
  ```

- Response:

  ```json
  {
    "comment_id": "int",
    "video_id": "int",
    "user_id": "int",
    "text": "string",
    "created_at": "datetime"
  }
  ```

**10. 删除评论**

- **Method:** DELETE

- **URL:** `/api/comments/{commentId}`

- Headers:

  ```makefile
  Authorization: Bearer Token
  ```

- Response:

  ```json
  {
    "success": "boolean",
    "message": "Comment deleted successfully"
  }
  ```

**11. 点赞视频**

- **Method:** POST

- **URL:** `/api/likes`

- Headers:

  ```makefile
  Authorization: Bearer Token
  ```

- Body:

  ```json
  {
    "video_id": "int"
  }
  ```

- Response:

  ```json
  {
    "like_id": "int",
    "video_id": "int",
    "user_id": "int",
    "created_at": "datetime"
  }
  ```

**12. 取消点赞**

- **Method:** DELETE

- **URL:** `/api/likes/{likeId}`

- Headers:

  ```makefile
  Authorization: Bearer Token
  ```

- Response:

  ```json
  {
    "success": "boolean",
    "message": "Like removed successfully"
  }
  ```

### 关注系统

**13. 关注用户**

- **Method:** POST

- **URL:** `/api/follows`

- Headers:

  ```makefile
  Authorization: Bearer Token
  ```

- Body:

  ```json
  {
    "followed_id": "int"
  }
  ```

- Response:

  ```json
  {
    "follow_id": "int",
    "follower_id": "int",
    "followed_id": "int",
    "created_at": "datetime"
  }
  ```

**14. 取消关注**

- **Method:** DELETE

- **URL:** `/api/follows/{followId}`

- Headers:

  ```makefile
  Authorization: Bearer Token
  ```

- Response:

  ```json
  {
    "success": "boolean",
    "message": "Unfollowed successfully"
  }
  ```

### 广告管理

**15. 获取广告列表**

- **Method:** GET

- **URL:** `/api/ads`

- Response:

  ```json
  {
    "ads": [
      {
        "ad_id": "int",
        "title": "string",
        "description": "string",
        "url": "string",
        "image_url": "string",
        "start_date": "datetime",
        "end_date": "datetime"
      }
    ]
  }
  ```

**16. 获取广告详情**

- **Method:** GET

- **URL:** `/api/ads/{adId}`

- Response:

  ```json
  {
    "ad_id": "int",
    "title": "string",
    "description": "string",
    "url": "string",
    "image_url": "string",
    "start_date": "datetime",
    "end_date": "datetime"
  }
  ```

**17. 创建广告**

- **Method:** POST

- **URL:** `/api/ads`

- Headers:

  ```makefile
  Authorization: Bearer Token
  ```

- Body:

  ```json
  {
    "title": "string",
    "description": "string",
    "url": "string",
    "image_url": "string",
    "start_date": "datetime",
    "end_date": "datetime"
  }
  ```

- Response:

  ```json
  {
    "ad_id": "int",
    "message": "Ad created successfully"
  }
  ```

**18. 更新广告**

- **Method:** PUT

- **URL:** `/api/ads/{adId}`

- Headers:

  ```
  Authorization: Bearer Token
  ```

- Body:

  ```json
  {
    "title": "string",
    "description": "string",
    "url": "string",
    "image_url": "string",
    "start_date": "datetime",
    "end_date": "datetime"
  }
  ```

- Response:

  ```json
  {
    "message": "Ad updated successfully"
  }
  ```

**19. 删除广告**

- **Method:** DELETE

- **URL:** `/api/ads/{adId}`

- Headers:

  ```makefile
  Authorization: Bearer Token
  ```

- Response:

  ```json
  {
    "message": "Ad deleted successfully"
  }
  ```

### 用户设置

**20. 获取用户设置**

- **Method:** GET

- **URL:** `/api/users/{userId}/settings`

- Headers:

  ```makefile
  Authorization: Bearer Token
  ```

- Response:

  ```json
  {
    "privacy": "string",
    "notifications": "boolean",
    "theme": "string",
    "language": "string"
  }
  ```

**21. 更新用户设置**

- **Method:** PUT

- **URL:** `/api/users/{userId}/settings`

- Headers:

  ```makefile
  Authorization: Bearer Token
  ```

- Body:

  ```json
  {
    "privacy": "string",
    "notifications": "boolean",
    "theme": "string",
    "language": "string"
  }
  ```

- Response:

  ```json
  {
    "message": "Settings updated successfully"
  }
  ```

### 内容审核

**22. 获取待审核内容**

- **Method:** GET

- **URL:** `/api/reviews/pending`

- Headers:

  ```makefile
  Authorization: Bearer Token
  ```

- Response:

  ```json
  {
    "reviews": [
      {
        "review_id": "int",
        "video_id": "int",
        "status": "string",
        "reviewer_id": "int",
        "notes": "string",
        "reviewed_at": "datetime"
      }
    ]
  }
  ```

**23. 审核内容**

- **Method:** POST

- **URL:** `/api/reviews/{reviewId}/approve`

- Headers:

  ```makefile
  Authorization: Bearer Token
  ```

- Body:

  ```json
  {
    "status": "string",
    "notes": "string"
  }
  ```

- Response:

  ```json
  {
    "message": "Review processed successfully"
  }
  ```

### 用户活动日志

**24. 获取用户活动日志**

- **Method:** GET

- **URL:** `/api/users/{userId}/activity_logs`

- Headers:

  ```makefile
  Authorization: Bearer Token
  ```

- Response:

  ```json
  {
    "logs": [
      {
        "log_id": "int",
        "activity_type": "string",
        "ip_address": "string",
        "device_info": "string",
        "created_at": "datetime"
      }
    ]
  }
  ```
