package br.com.githubusers.sample

import br.com.datalayer.model.RepoResponse
import br.com.datalayer.model.UserResponse
import br.com.domain.model.Repo
import br.com.domain.model.User
import br.com.domain.model.UserRepo


val usersTestSuccess = """
[
  {
    "login": "mojombo",
    "id": 1,
    "node_id": "MDQ6VXNlcjE=",
    "avatar_url": "https://avatars.githubusercontent.com/u/1?v=4",
    "gravatar_id": "",
    "url": "https://api.github.com/users/mojombo",
    "html_url": "https://github.com/mojombo",
    "followers_url": "https://api.github.com/users/mojombo/followers",
    "following_url": "https://api.github.com/users/mojombo/following{/other_user}",
    "gists_url": "https://api.github.com/users/mojombo/gists{/gist_id}",
    "starred_url": "https://api.github.com/users/mojombo/starred{/owner}{/repo}",
    "subscriptions_url": "https://api.github.com/users/mojombo/subscriptions",
    "organizations_url": "https://api.github.com/users/mojombo/orgs",
    "repos_url": "https://api.github.com/users/mojombo/repos",
    "events_url": "https://api.github.com/users/mojombo/events{/privacy}",
    "received_events_url": "https://api.github.com/users/mojombo/received_events",
    "type": "User",
    "site_admin": false
  },
  {
    "login": "defunkt",
    "id": 2,
    "node_id": "MDQ6VXNlcjI=",
    "avatar_url": "https://avatars.githubusercontent.com/u/2?v=4",
    "gravatar_id": "",
    "url": "https://api.github.com/users/defunkt",
    "html_url": "https://github.com/defunkt",
    "followers_url": "https://api.github.com/users/defunkt/followers",
    "following_url": "https://api.github.com/users/defunkt/following{/other_user}",
    "gists_url": "https://api.github.com/users/defunkt/gists{/gist_id}",
    "starred_url": "https://api.github.com/users/defunkt/starred{/owner}{/repo}",
    "subscriptions_url": "https://api.github.com/users/defunkt/subscriptions",
    "organizations_url": "https://api.github.com/users/defunkt/orgs",
    "repos_url": "https://api.github.com/users/defunkt/repos",
    "events_url": "https://api.github.com/users/defunkt/events{/privacy}",
    "received_events_url": "https://api.github.com/users/defunkt/received_events",
    "type": "User",
    "site_admin": false
  },
  {
    "login": "pjhyett",
    "id": 3,
    "node_id": "MDQ6VXNlcjM=",
    "avatar_url": "https://avatars.githubusercontent.com/u/3?v=4",
    "gravatar_id": "",
    "url": "https://api.github.com/users/pjhyett",
    "html_url": "https://github.com/pjhyett",
    "followers_url": "https://api.github.com/users/pjhyett/followers",
    "following_url": "https://api.github.com/users/pjhyett/following{/other_user}",
    "gists_url": "https://api.github.com/users/pjhyett/gists{/gist_id}",
    "starred_url": "https://api.github.com/users/pjhyett/starred{/owner}{/repo}",
    "subscriptions_url": "https://api.github.com/users/pjhyett/subscriptions",
    "organizations_url": "https://api.github.com/users/pjhyett/orgs",
    "repos_url": "https://api.github.com/users/pjhyett/repos",
    "events_url": "https://api.github.com/users/pjhyett/events{/privacy}",
    "received_events_url": "https://api.github.com/users/pjhyett/received_events",
    "type": "User",
    "site_admin": false
  }
]
""".trimIndent()

val userTestSuccess = """
{
  "login": "torvalds",
  "id": 1024025,
  "node_id": "MDQ6VXNlcjEwMjQwMjU=",
  "avatar_url": "https://avatars.githubusercontent.com/u/1024025?v=4",
  "gravatar_id": "",
  "url": "https://api.github.com/users/torvalds",
  "html_url": "https://github.com/torvalds",
  "followers_url": "https://api.github.com/users/torvalds/followers",
  "following_url": "https://api.github.com/users/torvalds/following{/other_user}",
  "gists_url": "https://api.github.com/users/torvalds/gists{/gist_id}",
  "starred_url": "https://api.github.com/users/torvalds/starred{/owner}{/repo}",
  "subscriptions_url": "https://api.github.com/users/torvalds/subscriptions",
  "organizations_url": "https://api.github.com/users/torvalds/orgs",
  "repos_url": "https://api.github.com/users/torvalds/repos",
  "events_url": "https://api.github.com/users/torvalds/events{/privacy}",
  "received_events_url": "https://api.github.com/users/torvalds/received_events",
  "type": "User",
  "site_admin": false,
  "name": "Linus Torvalds",
  "company": "Linux Foundation",
  "blog": "",
  "location": "Portland, OR",
  "email": null,
  "hireable": null,
  "bio": null,
  "twitter_username": null,
  "public_repos": 7,
  "public_gists": 0,
  "followers": 182107,
  "following": 0,
  "created_at": "2011-09-03T15:26:22Z",
  "updated_at": "2023-01-02T22:41:59Z"
}
""".trimIndent()

val reposTestSuccess = """
[
  {
    "id": 79171906,
    "node_id": "MDEwOlJlcG9zaXRvcnk3OTE3MTkwNg==",
    "name": "libdc-for-dirk",
    "full_name": "torvalds/libdc-for-dirk",
    "private": false,
    "owner": {
      "login": "torvalds",
      "id": 1024025,
      "node_id": "MDQ6VXNlcjEwMjQwMjU=",
      "avatar_url": "https://avatars.githubusercontent.com/u/1024025?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/torvalds",
      "html_url": "https://github.com/torvalds",
      "followers_url": "https://api.github.com/users/torvalds/followers",
      "following_url": "https://api.github.com/users/torvalds/following{/other_user}",
      "gists_url": "https://api.github.com/users/torvalds/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/torvalds/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/torvalds/subscriptions",
      "organizations_url": "https://api.github.com/users/torvalds/orgs",
      "repos_url": "https://api.github.com/users/torvalds/repos",
      "events_url": "https://api.github.com/users/torvalds/events{/privacy}",
      "received_events_url": "https://api.github.com/users/torvalds/received_events",
      "type": "User",
      "site_admin": false
    },
    "html_url": "https://github.com/torvalds/libdc-for-dirk",
    "description": "Only use for syncing with Dirk, don't use for anything else",
    "fork": true,
    "url": "https://api.github.com/repos/torvalds/libdc-for-dirk",
    "forks_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/forks",
    "keys_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/keys{/key_id}",
    "collaborators_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/collaborators{/collaborator}",
    "teams_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/teams",
    "hooks_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/hooks",
    "issue_events_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/issues/events{/number}",
    "events_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/events",
    "assignees_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/assignees{/user}",
    "branches_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/branches{/branch}",
    "tags_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/tags",
    "blobs_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/git/blobs{/sha}",
    "git_tags_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/git/tags{/sha}",
    "git_refs_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/git/refs{/sha}",
    "trees_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/git/trees{/sha}",
    "statuses_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/statuses/{sha}",
    "languages_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/languages",
    "stargazers_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/stargazers",
    "contributors_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/contributors",
    "subscribers_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/subscribers",
    "subscription_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/subscription",
    "commits_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/commits{/sha}",
    "git_commits_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/git/commits{/sha}",
    "comments_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/comments{/number}",
    "issue_comment_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/issues/comments{/number}",
    "contents_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/contents/{+path}",
    "compare_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/compare/{base}...{head}",
    "merges_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/merges",
    "archive_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/{archive_format}{/ref}",
    "downloads_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/downloads",
    "issues_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/issues{/number}",
    "pulls_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/pulls{/number}",
    "milestones_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/milestones{/number}",
    "notifications_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/notifications{?since,all,participating}",
    "labels_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/labels{/name}",
    "releases_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/releases{/id}",
    "deployments_url": "https://api.github.com/repos/torvalds/libdc-for-dirk/deployments",
    "created_at": "2017-01-17T00:25:49Z",
    "updated_at": "2023-05-07T20:51:28Z",
    "pushed_at": "2023-03-16T22:13:15Z",
    "git_url": "git://github.com/torvalds/libdc-for-dirk.git",
    "ssh_url": "git@github.com:torvalds/libdc-for-dirk.git",
    "clone_url": "https://github.com/torvalds/libdc-for-dirk.git",
    "svn_url": "https://github.com/torvalds/libdc-for-dirk",
    "homepage": "",
    "size": 3780,
    "stargazers_count": 192,
    "watchers_count": 192,
    "language": "C",
    "has_issues": false,
    "has_projects": true,
    "has_downloads": true,
    "has_wiki": true,
    "has_pages": false,
    "has_discussions": false,
    "forks_count": 51,
    "mirror_url": null,
    "archived": false,
    "disabled": false,
    "open_issues_count": 1,
    "license": {
      "key": "lgpl-2.1",
      "name": "GNU Lesser General Public License v2.1",
      "spdx_id": "LGPL-2.1",
      "url": "https://api.github.com/licenses/lgpl-2.1",
      "node_id": "MDc6TGljZW5zZTEx"
    },
    "allow_forking": true,
    "is_template": false,
    "web_commit_signoff_required": false,
    "topics": [

    ],
    "visibility": "public",
    "forks": 51,
    "open_issues": 1,
    "watchers": 192,
    "default_branch": "Subsurface-branch"
  },
  {
    "id": 519408694,
    "node_id": "R_kgDOHvWMNg",
    "name": "libgit2",
    "full_name": "torvalds/libgit2",
    "private": false,
    "owner": {
      "login": "torvalds",
      "id": 1024025,
      "node_id": "MDQ6VXNlcjEwMjQwMjU=",
      "avatar_url": "https://avatars.githubusercontent.com/u/1024025?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/torvalds",
      "html_url": "https://github.com/torvalds",
      "followers_url": "https://api.github.com/users/torvalds/followers",
      "following_url": "https://api.github.com/users/torvalds/following{/other_user}",
      "gists_url": "https://api.github.com/users/torvalds/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/torvalds/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/torvalds/subscriptions",
      "organizations_url": "https://api.github.com/users/torvalds/orgs",
      "repos_url": "https://api.github.com/users/torvalds/repos",
      "events_url": "https://api.github.com/users/torvalds/events{/privacy}",
      "received_events_url": "https://api.github.com/users/torvalds/received_events",
      "type": "User",
      "site_admin": false
    },
    "html_url": "https://github.com/torvalds/libgit2",
    "description": "A cross-platform, linkable library implementation of Git that you can use in your application.",
    "fork": true,
    "url": "https://api.github.com/repos/torvalds/libgit2",
    "forks_url": "https://api.github.com/repos/torvalds/libgit2/forks",
    "keys_url": "https://api.github.com/repos/torvalds/libgit2/keys{/key_id}",
    "collaborators_url": "https://api.github.com/repos/torvalds/libgit2/collaborators{/collaborator}",
    "teams_url": "https://api.github.com/repos/torvalds/libgit2/teams",
    "hooks_url": "https://api.github.com/repos/torvalds/libgit2/hooks",
    "issue_events_url": "https://api.github.com/repos/torvalds/libgit2/issues/events{/number}",
    "events_url": "https://api.github.com/repos/torvalds/libgit2/events",
    "assignees_url": "https://api.github.com/repos/torvalds/libgit2/assignees{/user}",
    "branches_url": "https://api.github.com/repos/torvalds/libgit2/branches{/branch}",
    "tags_url": "https://api.github.com/repos/torvalds/libgit2/tags",
    "blobs_url": "https://api.github.com/repos/torvalds/libgit2/git/blobs{/sha}",
    "git_tags_url": "https://api.github.com/repos/torvalds/libgit2/git/tags{/sha}",
    "git_refs_url": "https://api.github.com/repos/torvalds/libgit2/git/refs{/sha}",
    "trees_url": "https://api.github.com/repos/torvalds/libgit2/git/trees{/sha}",
    "statuses_url": "https://api.github.com/repos/torvalds/libgit2/statuses/{sha}",
    "languages_url": "https://api.github.com/repos/torvalds/libgit2/languages",
    "stargazers_url": "https://api.github.com/repos/torvalds/libgit2/stargazers",
    "contributors_url": "https://api.github.com/repos/torvalds/libgit2/contributors",
    "subscribers_url": "https://api.github.com/repos/torvalds/libgit2/subscribers",
    "subscription_url": "https://api.github.com/repos/torvalds/libgit2/subscription",
    "commits_url": "https://api.github.com/repos/torvalds/libgit2/commits{/sha}",
    "git_commits_url": "https://api.github.com/repos/torvalds/libgit2/git/commits{/sha}",
    "comments_url": "https://api.github.com/repos/torvalds/libgit2/comments{/number}",
    "issue_comment_url": "https://api.github.com/repos/torvalds/libgit2/issues/comments{/number}",
    "contents_url": "https://api.github.com/repos/torvalds/libgit2/contents/{+path}",
    "compare_url": "https://api.github.com/repos/torvalds/libgit2/compare/{base}...{head}",
    "merges_url": "https://api.github.com/repos/torvalds/libgit2/merges",
    "archive_url": "https://api.github.com/repos/torvalds/libgit2/{archive_format}{/ref}",
    "downloads_url": "https://api.github.com/repos/torvalds/libgit2/downloads",
    "issues_url": "https://api.github.com/repos/torvalds/libgit2/issues{/number}",
    "pulls_url": "https://api.github.com/repos/torvalds/libgit2/pulls{/number}",
    "milestones_url": "https://api.github.com/repos/torvalds/libgit2/milestones{/number}",
    "notifications_url": "https://api.github.com/repos/torvalds/libgit2/notifications{?since,all,participating}",
    "labels_url": "https://api.github.com/repos/torvalds/libgit2/labels{/name}",
    "releases_url": "https://api.github.com/repos/torvalds/libgit2/releases{/id}",
    "deployments_url": "https://api.github.com/repos/torvalds/libgit2/deployments",
    "created_at": "2022-07-30T03:30:56Z",
    "updated_at": "2023-05-11T17:50:06Z",
    "pushed_at": "2022-09-19T09:08:02Z",
    "git_url": "git://github.com/torvalds/libgit2.git",
    "ssh_url": "git@github.com:torvalds/libgit2.git",
    "clone_url": "https://github.com/torvalds/libgit2.git",
    "svn_url": "https://github.com/torvalds/libgit2",
    "homepage": "https://libgit2.org/",
    "size": 62768,
    "stargazers_count": 68,
    "watchers_count": 68,
    "language": "C",
    "has_issues": false,
    "has_projects": true,
    "has_downloads": true,
    "has_wiki": false,
    "has_pages": false,
    "has_discussions": false,
    "forks_count": 9,
    "mirror_url": null,
    "archived": false,
    "disabled": false,
    "open_issues_count": 1,
    "license": {
      "key": "other",
      "name": "Other",
      "spdx_id": "NOASSERTION",
      "url": null,
      "node_id": "MDc6TGljZW5zZTA="
    },
    "allow_forking": true,
    "is_template": false,
    "web_commit_signoff_required": false,
    "topics": [

    ],
    "visibility": "public",
    "forks": 9,
    "open_issues": 1,
    "watchers": 68,
    "default_branch": "main"
  }
]
""".trimIndent()


val usersResponse = listOf(
    UserResponse(
        id = 1,
        login = "test1",
        name = "test 1",
        avatarUrl = "url1"
    ),
    UserResponse(
        id = 2,
        login = "test1",
        name = "test 1",
        avatarUrl = "url1"
    ),
    UserResponse(
        id = 3,
        login = "test1",
        name = "test 1",
        avatarUrl = "url1"
    )
)

val userResponse = UserResponse(
    id = 1,
    login = "test1",
    name = "test 1",
    avatarUrl = "url1"
)

val userReposResponse = listOf(
    RepoResponse(
        id = 1,
        name = "repo1",
        fullName = "repo 1",
        url = "url1"
    ),
    RepoResponse(
        id = 2,
        name = "repo2",
        fullName = "repo 2",
        url = "url2"
    ),
    RepoResponse(
        id = 3,
        name = "repo3",
        fullName = "repo 3",
        url = "url3"
    )
)

val users = listOf(
    User(
        id = 1,
        login = "test1",
        name = "test 1",
        avatarUrl = "url1"
    ),
    User(
        id = 2,
        login = "test1",
        name = "test 1",
        avatarUrl = "url1"
    ),
    User(
        id = 3,
        login = "test1",
        name = "test 1",
        avatarUrl = "url1"
    )
)

val userRepos = UserRepo(
    user = User(
        id = 1,
        login = "test1",
        name = "test 1",
        avatarUrl = "url1"
    ),
    userRepos = listOf(
        Repo(
            id = 1,
            name = "repo1",
            fullName = "repo 1",
            url = "url1"
        ),
        Repo(
            id = 2,
            name = "repo2",
            fullName = "repo 2",
            url = "url2"
        ),
        Repo(
            id = 3,
            name = "repo3",
            fullName = "repo 3",
            url = "url3"
        )
    )
)