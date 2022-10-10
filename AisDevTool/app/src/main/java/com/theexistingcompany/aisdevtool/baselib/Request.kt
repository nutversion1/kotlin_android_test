package com.theexistingcompany.aisdevtool.baselib

data class Request<T>(var value: T, var needFresh: Boolean?)