Response Data 형식:

```json
{
    msg:'',
    code:'',
    status:false/true,
    data:
}
```





신규프로젝트 등록 페이지:

1.Query Requsest

URL: /season

Method: Get

Reponse Data:

```json
{
    msg:'',
    code:'',
    status:false/true,
    data:{
        	businessDepartTeams:[],
            years: [],
            seasons: [],
            customerCompany: [],
            winStatus: [],
		 }
}
```

`	1.2 

Request

url:/project/projectRecord/queryProjects

method:post,

post data Type:

```json
{
          "businessDepartTeam": '',
          "year": '',
          "season": '',
          "customerCompany": '',
          "winStatus": ''
};
```

1.2 Response

​		Data Type

​		

```json
{
    msg:'',
    code:'',
    status:false/true,
    data:{
        	dataSource:{
                 [
                	businDepartTeamName:
                	projectNameCode:
                    year:
                    customerCompany:
                    gender:
                    season:
                    goodsType:
                    winStatus:
                ],
                [
                    businDepartTeamName:
                	projectNameCode:
                    year:
                    customerCompany:
                    gender:
                    season:
                    goodsType:
                ]
            },
        	filtersData:{
                "yearFilters": [
                    				{text:"",value:""},
                    				{text:"",value:""},
                    				{text:"2019",value:"2019"},
                			   ],
                "customerCompanyFilters": [],
                "genderFilters": [],
                "seasonFilters": [],
                "goodsTypeFilters": [],
                "winStatusFilters": []
            }
    	 }
}
```



1. 추가 Request

   URL: /season

   Method: Get

```JSON
{
    msg:'',
    code:'',
    status:false/true,
    data:[
        	{key:"1",code:"1",value:"하계"},
			{key:"2",code:"2",value:"동계"},
            {key:"3",code:"3",value:"춘추"},
            {key:"4",code:"4",value:"사계절"},
            {key:"5",code:"5",value:"기타"},
    ]
}
```

