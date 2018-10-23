package controller

import (
	"net/http"
)

func IndexGET(c *gin.COntext) {
	c.String(http.StatusOK, "Hellomworld!")
}
